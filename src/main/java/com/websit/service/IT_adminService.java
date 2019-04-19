package com.websit.service;

import com.websit.entity.T_admin;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public interface IT_adminService extends IService<T_admin> {

	
	public T_admin selectbyName(@Param("username") String name);
	
	public Integer selectby(T_admin t);
	
	/**
	 * 查询后台管理员用户列表
	 *
	 * @Title: findAdminList
	 * @description 
	 * @param page 当前页
	 * @param limit 每页显示条数
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午4:04:38
	 */
	public String findAdminList(Integer page, Integer limit);
	
	/**
	 * 通过id查询管理员账户信息
	 *
	 * @Title: findAdminById
	 * @description 
	 * @param id
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午4:05:13
	 */
	public String findAdminById(Long id);
	
	/**
	 * 通过id删除管理员账户
	 *
	 * @Title: deleteAdminById
	 * @description 
	 * @param id
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午3:50:12
	 */
	public String deleteAdminById(Long id);
	
	/**
	 * 通过姓名或者电话查询管理员信息
	 *
	 * @Title: findAdminListByNameOrPhone
	 * @description 
	 * @param map 封装查询信息
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月2日-下午5:02:25
	 */
	public String findAdminListByNameOrPhone(Map<String, Object> map);
	
	/**
	 * 通过id修改管理员账号信息
	 *
	 * @Title: updateAdminById
	 * @description 
	 * @param id
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月3日-下午5:11:32
	 */
	public String updateAdminById(T_admin admin);
	
	
	
}
