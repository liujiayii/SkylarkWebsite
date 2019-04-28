package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_admin;
import com.websit.mapper.T_adminMapper;
import com.websit.service.IT_adminService;
import com.websit.until.JsonUtil;
import com.websit.until.MD5Utils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.mapper.T_permissionMapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
public class T_adminServiceImpl extends ServiceImpl<T_adminMapper, T_admin> implements IT_adminService {

	@Autowired
	private T_adminMapper adminMapper; 
	
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
		T_admin admin = null;
		
		try {
			admin = adminMapper.selectById(id);
			
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
				msg = ReturnCode.FAILED_DELETE_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
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
		Page<T_admin> adminPage = new Page<> ((int)map.get("current"), (int)map.get("size"));
		List<T_admin> selectPage = null;
		EntityWrapper<T_admin> ew = new EntityWrapper<T_admin> ();

		if ( map.get("name") != null ) {
			ew.like("name", map.get("name").toString());
		} else if ( map.get("phone") != null ) {
			ew.like("phone", map.get("phone").toString());
		}
		
		try {
			adminPage.setRecords(adminMapper.findAdminList(adminPage));
			selectPage = adminMapper.selectPage(adminPage, ew);
			
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
	 * 通过id修改管理员账号
	 */
	public String updateAdminById(T_admin admin) {
		String msg = ReturnCode.SUCCESS_UPDATE_MSG;
		int code = ReturnCode.SUCCSEE_CODE;
		try {
			String password = (adminMapper.selectById(admin.getId())).getPassword();
			
			if (!admin.getPassword().equals(password)) {
				admin.setPassword(MD5Utils.encryptPassword(admin.getPassword(), "KwX3jBV5hOmTSUdc"));
			} 
			
			Integer updateById = adminMapper.updateById(admin);
			
			if (updateById > 0) {
				JsonUtil.getResponseJson(code, ReturnCode.FAILED_UPDATE_MSG, null, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.EXCEPTION_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, null, null);
	}
	
	
}
