package com.websit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_posting;
import com.websit.entityvo.PostingForUpdateVo;
import com.websit.entityvo.PostingPlateVo;
import com.websit.entityvo.T_postingVo;

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
	 * @param page 当前页
	 * @param row 显示条数
	 * @return  
	 * List<PostingPlateVo>    
	 * @author lujinpeng
	 * @createDate 2019年3月21日-上午10:02:24
	 */
	List<PostingPlateVo> selectHotPotings(@Param("page") Integer page, @Param("row") Integer row);
	
	/**
	 * 查询热门帖子总数量
	 *
	 * @Title: selectHotCounts
	 * @description 
	 * @param page
	 * @param row
	 * @return  
	 * int    
	 * @author lujinpeng
	 * @createDate 2019年3月19日-下午1:44:52
	 */
	int selectHotCounts(@Param("page") Integer page, @Param("row") Integer row);
	
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
	List<PostingPlateVo> selectNewestPotings(@Param("plate_id") Long plate_id, @Param("row") Integer row);
	
	/**
	 * 查询精华帖子
	 *
	 * @Title: selectGoodPostings
	 * @description 
	 * @param isGood 是否精华帖
	 * @param row 查询条数
	 * @return  
	 * List<PostingPlateVo>    
	 * @author lujinpeng
	 * @createDate 2019年3月18日-下午5:27:52
	 */
	List<PostingPlateVo> selectGoodPostings(@Param("isGood") Integer isGood, @Param("row") Integer row);
	
	/**
	 * @Title: selecAllSome
	 * @description 查询个人贴子数量
	 * @return List<T_postingVo> 
	 * @author pangchong
	 * @createDate 2019年03月15日
	 */
	public Integer selectPostingCount();
	/**
	 * @Title: selectNewMember
	 * @description 1.2 显示最新一个会员名称
	 * @return String    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	public String selectNewMember();
	
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
