package com.websit.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_posting;
import com.websit.entityvo.T_postingVo;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 发帖表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_postingMapper extends BaseMapper<T_posting> {
	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月14日
	 */
	public List<T_postingVo> selecAllSome(T_postingVo postingVo);
	
	/**
	 * 查询热门帖子（回帖最多）
	 *
	 * @Title: selectHotPotings
	
	 * @description 
	 *
	 * @param row 查询热门帖子条数
	 * @return 
	   
	 * List<T_posting>
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:28:58
	 */
	List<T_posting> selectHotPotings(Integer row);
	
	/**
	 * 查询最新帖子
	 *
	 * @Title: selectNewestPotings
	
	 * @description 
	 *
	 * @param row 查询条数
	 * @return 
	   
	 * List<T_posting>
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月14日-下午5:50:43
	 */
	List<T_posting> selectNewestPotings(Integer row);
	
	/**
	 * @Title: selecAllSome
	 * @description 查询个人贴子数量
	 * @return List<T_postingVo> 
	 * @author pangchong
	 * @createDate 2019年03月15日
	 */
	public Integer selectPostingCount(T_postingVo postingVo);
}
