package com.websit.service.impl;

import com.websit.entity.T_permission;
import com.websit.mapper.T_permissionMapper;
import com.websit.service.IT_permissionService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * 左侧菜单列表
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
		List<T_permission> permissionList = permissionMapper.selectList(new EntityWrapper<T_permission>().eq("pid", 0));
		
		for (T_permission permission : permissionList) {
			Map<String, Object> map = new HashMap<>();
			Map<String, Object> meta = new HashMap<>();
			List<Object> children = new ArrayList<>();
			// 查询二级菜单
			List<T_permission> permissionListTwo = permissionMapper.selectList(new EntityWrapper<T_permission>().eq("pid", permission.getId()));
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

	
	
}
