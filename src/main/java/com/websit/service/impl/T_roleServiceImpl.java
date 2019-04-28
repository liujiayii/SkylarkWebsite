package com.websit.service.impl;

import com.websit.entity.T_role;
import com.websit.mapper.T_roleMapper;
import com.websit.service.IT_roleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  角色表服务实现类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
@Service
public class T_roleServiceImpl extends ServiceImpl<T_roleMapper, T_role> implements IT_roleService {

	@Autowired
	private T_roleMapper roleMapper;
	
	/**
	 * 查询所有角色信息
	 */
	@Override
	public List<T_role> findAll() {
		
		return roleMapper.findAll();
	}

	/**
	 * 通过管理员id查询角色
	 */
	@Override
	public List<T_role> selectRoleByAdminId(Long admin_id) {
		
		return roleMapper.selectRoleByAdminId(admin_id);
	}

	/**
	 * 添加角色
	 */
	@Override
	public int insertRole(T_role role) {
		
		return roleMapper.insertRole(role);
	}

	/**
	 * 修改角色
	 */
	@Override
	public int updateRole(T_role role) {
		
		return roleMapper.updateRole(role);
	}

	/**
	 * 删除角色
	 */
	@Override
	public int deleteRole(Long id) {
		
		return roleMapper.deleteRole(id);
	}

	/**
	 * 为角色批量添加权限
	 */
	@Override
	public int insertPermsForRole(List<Map<String, Object>> maps) {
		
		return roleMapper.insertPermsForRole(maps);
	}

	

}
