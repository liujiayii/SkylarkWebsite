package com.websit.mapper;

import com.websit.entity.T_review;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.T_reviewVo;

import java.math.BigInteger;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品评论表(蔺) Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public interface T_reviewMapper extends BaseMapper<T_review> {
	/**
	 * @Title: insertReview
	 * @description 添加添加评论
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhognyu
	 * @createDate 2019年3月22日
	 */
	public int insertReview(T_review t_review);
	/**
	 * @Title: updateOnethin
	 * @description 商家回复
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public int updateOnethin(T_review t_review);
	/**
	 * @Title: seleceFirstThin
	 * @description 通过评论表id查询评论详情
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public T_reviewVo seleceFirstThin(long id);
	/**
	 * @Title: selectAllSome
	 * @description 通过商品表id查询所有商品评论
	 * @param @param id
	 * @param @return    
	 * @return List<T_reviewVo>    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public List<T_reviewVo> selectAllSome(T_reviewVo reviewVo);
	/**
	 * @Title: selectCounts
	 * @description 通过商品表id查询所有商品评论总条数
	 * @param @param id
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public int selectCounts(long id);
	/**
	 * @Title: selectappraise
	 * @description 查询评论分数平均分
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public int selectappraise(long id);
	/**
	 * @Title: seleceUserThin
	 * @description 通过用户id查询历史评价
	 * @param @param id
	 * @param @return    
	 * @return T_reviewVo    
	 * @author 姓名全拼
	 * @createDate 2019年3月22日
	 */
	public List<T_reviewVo> seleceUserThin(T_reviewVo reviewVo);
	/***
	 * @Title: selectAllEvery
	 * @description 查询所有评论
	 * @param @param reviewVo
	 * @param @return    
	 * @return List<T_reviewVo>    
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	public List<T_reviewVo> selectAllEvery(T_reviewVo reviewVo);
	
	/***
	 * @Title: selectAllEveryCount
	 * @description 查询所有评论数据条数
	 * @param @param reviewVo
	 * @param @return    
	 * @return int    
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	public int selectAllEveryCount(T_reviewVo reviewVo);
	/**
	 * @Title: seleceOne
	 * @description 查询评论状态
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	public List<T_orderVo> seleceOne(String order_id);
	/**
	 * @Title: updateState
	 * @description 修改订单状态
	 * @param @param order_on
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	public int updateState(String order_no);
}
