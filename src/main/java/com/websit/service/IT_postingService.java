package com.websit.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entity.T_posting;
import com.websit.entityvo.PostingForUpdateVo;
import com.websit.entityvo.T_postingVo;

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
	 * @Title: selectPostCounts
	 * @description 1.1 显示昨天、今天发帖数量以及总发帖数量
	 * @return String    
	 * @author lujinpeng
	 * @createDate 2019年3月15日
	 */
	String selectPostCounts();
	
	/**
	 * @Title: selectNewMember
	 * @description 1.2 显示最新一个会员名称
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	public String selectNewMember();
	
	/**
	 * @Title: selectPostingCount
	 * @description 查询个人贴子数量
	 * @return List<T_postingVo> 
	 * @author pangchong
	 * @createDate 2019年03月15日
	 */
	public Integer selectPostingCount();
	
	/**
	 *
	 * @Title: updatePostingTopState
	 * @description 修改帖子的置顶状态(是否置顶)
	 * @param @param postingVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	int updatePostingTopState(PostingForUpdateVo postingVo);
	
	/**
	 *
	 * @Title: updatePostingDelState
	 * @description 修改帖子的删除状态(是否删除)
	 * @param @param postingVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	int updatePostingDelState(PostingForUpdateVo postingVo);
	
	/**
	 *
	 * @Title: updatePostingGoodState
	 * @description 修改帖子的精华状态(是否为精华帖子)
	 * @param @param postingVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	int updatePostingGoodState(PostingForUpdateVo postingVo);
	
	/**
	 *
	 * @Title: countPostingByPlateId
	 * @description 通过板块id查询当前板块下的帖子的数量
	 * @param @param plate_id
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月4日
	 */
	public int countPostingByPlateId(Long plate_id);
	
	/**
	 *
	 * @Title: countTodayPosting
	 * @description 通过板块id和日期查询当前板块下的今日帖子的数量
	 * @param @param postingVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月4日
	 */
	public int countTodayPosting(T_postingVo postingVo);
	
	/**
	 * @Title: deletePostingById
	 * @description 删除一条帖子（硬删除）
	 * @param postingVo
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	public int deletePostingById(PostingForUpdateVo postingVo);
	
	

}
