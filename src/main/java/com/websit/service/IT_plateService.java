package com.websit.service;

import com.websit.entity.T_plate;
import com.websit.entityvo.PlateCompanyVo;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 板块表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_plateService extends IService<T_plate> {
	
	/**
	 * 查询所有论坛分类以及对应版块信息
	 *
	 * @Title: selectAllPlates
	 * @description 
	 * @return  
	 * String   
	 * @author lujinpeng
	 * @createDate 2019年3月18日-上午11:23:48
	 */
	String selectAllPlates();
	
	T_plate selectFindId(long id);
	
	/**
	 * 
	 * @Title: listCompanyPlate
	 * @description 2.1查询当前公司的所有板块列表
	 * @param @param company_id
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	String listCompanyPlate(Long company_id);
	
	/**
	 *
	 * @Title: countCompanyPlate
	 * @description 2.2查询当前公司的所有板块列表的数量
	 * @param @param company_id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	int countCompanyPlate(Long company_id);

}
