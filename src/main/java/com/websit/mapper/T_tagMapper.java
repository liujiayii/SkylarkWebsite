package com.websit.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_tag;

/**
 * 标签表mapper接口
 *
 * @ClassName: T_tagMapper

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月20日-上午11:10:47
 */
public interface T_tagMapper extends BaseMapper<T_tag> {
	
	/**
	 * 查询标签
	 *
	 * @Title: selectTags
	 * @description 
	 * @param t_tag
	 * @return  
	 * List<T_tag>    
	 * @author lujinpeng
	 * @createDate 2019年3月20日-上午11:28:47
	 */
	List<T_tag> selectTags(T_tag t_tag);
}
