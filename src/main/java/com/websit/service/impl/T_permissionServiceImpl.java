package com.websit.service.impl;

import com.websit.entity.T_permission;
import com.websit.entity.T_role_permission;
import com.websit.mapper.T_permissionMapper;
import com.websit.mapper.T_role_permissionMapper;
import com.websit.service.IT_permissionService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
@Service
public class T_permissionServiceImpl extends ServiceImpl<T_permissionMapper, T_permission> implements IT_permissionService {

	@Autowired
	private T_permissionMapper permissionMapper;
	
	@Autowired
	private T_role_permissionMapper role_permissionMapper;
	
	/**
	 * 左侧目录菜单显示
	 * 通过角色id查询是否拥有左侧导航菜单查看权限
	 */
	public List<Object> ListMenusByRoleId(Long role_id) {
		List<Object> menuList = new ArrayList<> ();
		// 存储目录对象集合
		List<T_permission> MList = new ArrayList<> ();
		// 存储菜单对象集合
		List<T_permission> CList = new ArrayList<> ();
		// 查询该角色所有权限对应关系
		List<T_role_permission> rolePermList = role_permissionMapper.selectList(new EntityWrapper<T_role_permission>()
				.eq("role_id", role_id));
		
		for (T_role_permission rolePerm : rolePermList) {
			T_permission permission = permissionMapper.selectById(rolePerm.getPermission_id());
			// 目录
			if ("M".equals(permission.getMenu_type())) {
				MList.add(permission);
			}
			// 菜单
			if ("C".equals(permission.getMenu_type())) {
				CList.add(permission);
			}
		}
		
		listSort(MList);
		listSort(CList);
		
		for (T_permission permission : MList) {
			Map<String, Object> map = new HashMap<>();
			List<Object> children = new ArrayList<>();
			
			for (T_permission rp : CList) {
				
				if (rp.getPid() == permission.getId()) {
					Map<String, Object> perm = new HashMap<>();
					perm.put("name", rp.getName());
					perm.put("path", rp.getUrl());
					perm.put("component", rp.getComponent());
					children.add(perm);
				}
			}
			
			map.put("Ico", permission.getIcon());
			map.put("name", permission.getName());
			map.put("path", permission.getUrl());
			map.put("component", permission.getComponent());
			map.put("children", children);
			
			menuList.add(map);
		}
		
		return menuList;
	}
	
	/** 排序 */
	private void listSort(List<T_permission> list) {
		Collections.sort(list, new Comparator<T_permission>() {

			@Override
			public int compare(T_permission arg0, T_permission arg1) {
				int diff = arg0.getOrder_num() - arg1.getOrder_num();
				if (diff > 0) {
					return 1;
				} else if (diff < 0) {
					return -1;
				}
				return 0;
			}
		});
	}
	
	/**
	 * 左侧菜单列表（没有角色权限约束）
	 * 返回数据格式：
	 * [
	 * 	 {
            "name": "云阙商城",
            "path": "/mall",
            "children": [
                {
                    "name": "商品列表",
                    "path": "ware",
                    "meta": {
                        "title": "云阙商城"
                    }
                }
            ],
            "Ico": "md-basket"
          }
	 * ]
	 */
	@Override
	public List<Object> ListMenu() {
		List<Object> menuList = new ArrayList<> ();
		// 查询目录
		List<T_permission> permissionList = permissionMapper.selectList(new EntityWrapper<T_permission>().eq("pid", 0).orderBy("order_num"));
		
		for (T_permission permission : permissionList) {
			Map<String, Object> map = new HashMap<>();
			Map<String, Object> meta = new HashMap<>();
			List<Object> children = new ArrayList<>();
			// 查询二级菜单
			List<T_permission> permissionListTwo = permissionMapper.selectList(new EntityWrapper<T_permission>().eq("pid", permission.getId()).orderBy("order_num"));
			meta.put("title", permission.getName());
			String metaStr = JSONObject.toJSONString(meta, SerializerFeature.DisableCircularReferenceDetect);
			
			for (T_permission tp : permissionListTwo) {
				Map<String, Object> perm = new HashMap<>();
				perm.put("name", tp.getName());
				perm.put("path", tp.getUrl());
				perm.put("component", tp.getComponent());
				perm.put("meta", JSONObject.parseObject(metaStr));
				children.add(perm);
			}
			
			map.put("Ico", permission.getIcon());
			map.put("name", permission.getName());
			map.put("path", permission.getUrl());
			map.put("component", permission.getComponent());
			map.put("children", children);
			
			menuList.add(map);
		}
		
		return menuList;
	}

	/**
	 * 添加权限
	 */
	@Override
	public int insertPermission(T_permission permission) {
		
		return permissionMapper.insertPermission(permission);
	}

	/**
	 * 修改权限
	 */
	@Override
	public int updatePermission(T_permission permission) {
		
		return permissionMapper.updatePermission(permission);
	}

	/**
	 * 删除权限
	 */
	@Override
	public int deletePermission(Long id) {
		
		return permissionMapper.deletePermission(id);
	}

	/**
	 * 将对象中的属性以及属性值添加到map集合中
	 */
	@Override
	public void getAttribute(Object obj, Map<String, Object> map) {
		Class<? extends Object> class1 = obj.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		
		for (int i = 0; i < declaredFields.length; i++) {
			Field f = declaredFields[i];
			f.setAccessible(true);
			try {
				map.put(f.getName(), f.get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}		
	}

	
	
}
