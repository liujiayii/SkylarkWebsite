package com.websit.service.impl;
import com.websit.entity.T_review;
import com.websit.entityvo.T_orderVo;
import com.websit.entityvo.T_reviewVo;
import com.websit.mapper.T_reviewMapper;
import com.websit.service.IT_reviewService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评论表(蔺) 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
@Service
public class T_reviewServiceImpl extends ServiceImpl<T_reviewMapper, T_review> implements IT_reviewService {
	@Autowired
	private T_reviewMapper t_reviewMapper;
	/**
	 * @Title: insertReview
	 * @description 添加添加评论
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhognyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public int insertReview(T_review t_review) {
		return t_reviewMapper.insertReview(t_review);
	}
	/**
	 * @Title: updateOnethin
	 * @description 商家回复
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public int updateOnethin(T_review t_review) {
		return t_reviewMapper.updateOnethin(t_review);
	}
	/**
	 * @Title: selectappraise
	 * @description 查询评论分数平均分
	 * @param @param t_review
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public int selectappraise(long id) {
		return t_reviewMapper.selectappraise(id);
	}
	/**
	 * @Title: seleceUserThin
	 * @description 通过用户id查询历史评价
	 * @param @param id
	 * @param @return    
	 * @return T_reviewVo    
	 * @author 姓名全拼
	 * @createDate 2019年3月22日
	 */
	@Override
	public List<T_reviewVo> seleceUserThin(T_reviewVo reviewVo) {
		return t_reviewMapper.seleceUserThin(reviewVo);
	}
	/**
	 * @Title: selectAllSome
	 * @description 通过商品表id查询所有商品评论
	 * @param @param id
	 * @param @return    
	 * @return List<T_reviewVo>    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public List<T_reviewVo> selectAllSome(T_reviewVo reviewVo) {
		return t_reviewMapper.selectAllSome(reviewVo);
	}
	/**
	 * @Title: seleceFirstThin
	 * @description 通过评论表id查询评论详情
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public T_reviewVo seleceFirstThin(long id) {
		return t_reviewMapper.seleceFirstThin(id);
	}
	/***
	 * @Title: selectAllEvery
	 * @description 查询所有评论
	 * @param @param reviewVo
	 * @param @return    
	 * @return List<T_reviewVo>    
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	@Override
	public List<T_reviewVo> selectAllEvery(T_reviewVo reviewVo) {
		return t_reviewMapper.selectAllEvery(reviewVo);
	}
	/***
	 * @Title: selectAllEveryCount
	 * @description 查询所有评论数据条数
	 * @param @param reviewVo
	 * @param @return    
	 * @return int    
	 * @author 姓名全拼
	 * @createDate 2019年3月26日
	 */
	@Override
	public int selectAllEveryCount(T_reviewVo reviewVo) {
		return t_reviewMapper.selectAllEveryCount(reviewVo);
	}
	/**
	 * @Title: seleceOne
	 * @description 查询评论状态
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	@Override
	public List<T_orderVo> seleceOne(String order_id) {
		return t_reviewMapper.seleceOne(order_id);
	}
	/**
	 * @Title: updateState
	 * @description 修改订单状态
	 * @param @param order_no
	 * @param @return    
	 * @return int    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	@Override
	public int updateState(String order_no) {
		return t_reviewMapper.updateState(order_no);
	}
}
