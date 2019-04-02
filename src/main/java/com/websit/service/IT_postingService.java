package com.websit.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entity.T_posting;
import com.websit.entityvo.T_postingVo;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 发帖表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_postingService extends IService<T_posting> {
	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表不置顶
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月14日
	 */
	public List<T_postingVo> selecAllSome(T_postingVo postingVo);
	/**
	 * @Title: selecAllSomeTop
	 * @description 查询版主下的话题列表置顶
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月19日
	 */
	public List<T_postingVo> selecAllSomeTop(T_postingVo postingVo);
	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表条数
	 * @return T_postingVo
	 * @author linhongyu
	 * @createDate 2019年03月15日
	 */
	public T_postingVo selectCountTwo(T_postingVo postingVo);
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
	String showHotPostings(Integer page, Integer row);
	
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
	String showNewestPotings(Long plate_id, Integer row);
	
	/**
	 * 查询精华帖子
	 *
	 * @Title: showGoodPosting
	
	 * @description 
	 *
	 * @param row 查询精华帖子数量
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月15日-上午9:48:44
	 */
	String showGoodPostings(Integer row);
	
	/**
	 * 发帖计数
	 *
	 * @Title: postCount
	
	 * @description 
	 *
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月15日-上午11:01:38
	 */
	String selectPostCounts();
	
	/**
	 * @Title: selectPostingCount
	 * @description 查询个人贴子数量
	 * @return List<T_postingVo> 
	 * @author pangchong
	 * @createDate 2019年03月15日
	 */
	public Integer selectPostingCount();

}
