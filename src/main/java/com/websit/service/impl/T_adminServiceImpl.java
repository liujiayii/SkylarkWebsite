package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_admin;
import com.websit.entity.T_role_admin;
import com.websit.mapper.T_adminMapper;
import com.websit.mapper.T_admin_roleMapper;
import com.websit.service.IT_adminService;
import com.websit.service.IT_admin_roleService;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.mapper.T_permissionMapper;
import com.websit.mapper.T_roleMapper;
import com.websit.entity.T_permission;
import com.websit.entity.T_role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
@Service
public class T_adminServiceImpl extends ServiceImpl<T_adminMapper, T_admin> implements IT_adminService, UserDetailsService {

	@Autowired
	private T_adminMapper adminMapper;
	
	@Autowired
	private T_roleMapper roleMapper;
	
	@Autowired
	private T_admin_roleMapper admin_roleMapper;
	
	@Autowired
	private T_permissionMapper permissionMapper;
	
	@Override
	public T_admin selectbyName(String name) {
		
		return adminMapper.selectbyName(name);
	}

	@Override
	public Integer selectby(T_admin t) {
	
		return adminMapper.selectby(t);
	}

	/**
	 * 查询管理员账户列表(分页查询)
	 */
	@Override
	public String findAdminList(Integer current, Integer size) {
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		Page<T_admin> adminPage = new Page<> (current, size);
		List<T_admin> selectPage = null;
		
		if ( current == null || size == null ) {
			return JsonUtil.getResponseJson(code, "参数缺失", null, null);
		}
		
		try {
			adminPage.setRecords(adminMapper.findAdminList(adminPage));
			selectPage = adminMapper.findAdminList(adminPage);
			
			if (selectPage == null || selectPage.size() == 0) {
				msg = ReturnCode.NORESULT_SELECT_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, (int)adminPage.getTotal(), selectPage);
	}

	/**
	 * 通过id查询管理员信息
	 */
	@Override
	public String findAdminById(Long id) {
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		T_admin admin = new T_admin();
		
		try {
			//admin = adminMapper.selectById(id);
			admin.setId(id);
			admin = adminMapper.selectListSelective(admin).get(0);
			if (admin == null) {
				msg = ReturnCode.NORESULT_SELECT_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, admin);
	}

	/**
	 * 通过id删除管理员账户
	 */
	@Override
	public String deleteAdminById(Long id) {
		String msg = ReturnCode.SUCCESS_DELETE_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		
		try {
			if (adminMapper.deleteById(id) > 0) {
				// 删除用户角色关联信息
				admin_roleMapper.delete(new EntityWrapper<T_role_admin>().eq("admin_id", id));
				msg = ReturnCode.SUCCESS_DELETE_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_DELETE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}

	/**
	 * 通过管理员姓名或者电话查询
	 */
	@Override
	public String findAdminListByNameOrPhone(Map<String, Object> map) {
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		int count = 0;
		List<T_admin> admins = null;
		
		try {
			admins = adminMapper.findAdminListByNameOrPhone(map);
			Map<String, Object> map2 = new HashMap<>();
			map2.put("name", map.get("name"));
			map2.put("phone", map.get("phone"));
			map2.put("page", null);
			map2.put("limit", null);
			count = adminMapper.findAdminListByNameOrPhone(map2).size();
			
			if (admins == null || admins.size() == 0) {
				msg = ReturnCode.NORESULT_SELECT_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, count, admins);
	}
	
	/**
	 * 通过id修改管理员账号
	 */
	@Override
	public String updateAdminById(T_admin admin) {
		String msg = ReturnCode.SUCCESS_UPDATE_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		
		try {
			String password = (adminMapper.findByUserName(admin.getUsername())).getPassword();
			T_role role = roleMapper.selectById(Long.parseLong(admin.getPost()));
			admin.setPost(role.getName());
			// 如果前端提交的密码不为空 并且 和数据库中的密码不相等，则修改密码
			if (admin.getPassword() != null && !password.equals(admin.getPassword())) {
				admin.setPassword(new BCryptPasswordEncoder().encode( admin.getPassword() ));
			} 
			// 修改用户表
			adminMapper.updateById(admin);
			List<T_role_admin> admin_roles = admin_roleMapper.selectList(new EntityWrapper<T_role_admin>().eq("admin_id", admin.getId()));
		    // 修改用户和角色之间的关系
			admin_roleMapper.updateById(new T_role_admin(admin_roles.get(0).getId(), admin.getId(), role.getId()));
			
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_UPDATE_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	/**
	 * 重写实现类方法
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 通过用户名称获取对象
		T_admin admin = adminMapper.findByUserName(username);
		
		if (admin != null) {
			List<T_permission> permissions = permissionMapper.selectPermsByUserId(admin.getId());
	        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
	        
	        for (T_permission permission : permissions) {
	            if (permission != null && permission.getPerms() != null) {
	                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPerms());
	                grantedAuthorities.add(grantedAuthority);
	            }
	        }
	        
	        return new User(admin.getUsername(), admin.getPassword(), admin.isEnabled()
	        				, admin.isAccountNonExpired(), admin.isCredentialsNonExpired()
	        				, admin.isAccountNonLocked(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("用户名: " + username + " 不存在!");
		}
		
	}

	/**
	 * 通过自定义条件查询
	 */
	@Override
	public List<T_admin> selectListSelective(T_admin admin) {
		
		return adminMapper.selectListSelective(admin);
	}

	/**
	 * 通过自定义条件修改
	 */
	@Override
	public int updateByIdSelective(T_admin admin) {
		
		return adminMapper.updateByIdSelective(admin);
	}

	/**
	 * 通过用户名查询
	 */
	@Override
	public T_admin findByUserName(String username) {
		
		return adminMapper.findByUserName(username);
	}
	
}
