package com.websit.mapper;

import com.websit.entity.T_plate;
import com.websit.entityvo.PlateCompanyVo;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 板块表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_plateMapper extends BaseMapper<T_plate> {
	
	/**
	 * 查询所有论坛分类以及对应版块信息
	 *
	 * @Title: selectAllPlates
	 * @description 
	 * @return  
	 * List<PlateCompanyVo>    
	 * @author lujinpeng
	 * @createDate 2019年3月18日-上午11:23:48
	 */
	List<PlateCompanyVo> selectAllPlates();
	
	/**
	 * 查询每个模块下的回帖总条数
	 *
	 * @Title: selectPlateCommentCount
	 * @description 
	 * @param plate_id
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年3月20日-上午10:13:42
	 */
	int selectPlateCommentCount(Long plate_id);
	
	T_plate selectFindId(long id);
}
