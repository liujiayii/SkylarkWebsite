package com.websit.mapper;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entityvo.T_replylist;
/**
 * <p>
 * 评论回复表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_replyMapper extends BaseMapper<T_reply> {
	/**
	 * 查询评论的方法
	 * @param posting_id
	 * @return
	 */
	List<postinglist>postinglist(String posting_id,RowBounds RowBounds);
	/**
	 * 查询评论的方法
	 * @param posting_id
	 * @return
	 */
	List<postinglist> t_commentlist(String posting_id);
	/**
	 * 查询标题的方法
	 * @param posting_id
	 * @return
	 */
	public List<T_plateputing> tret(String posting_id);
	/**
	 * 查询回复的数据
	 * @param comment_id
	 * @return
	 */
	List<T_replylist> T_replylist(@Param("comment_id")String comment_id,RowBounds RowBounds);
	/***
	 * 
	 * @param comment_id
	 * @return
	 */
	 int updime(String comment_id);
		/***
		 * 
		 * @param posting_id
		 * @return
		 */
	int number(String posting_id);
	
	int querlist(String posting_id);
	/**
	 * 查询回复的回复总数量
	 * @param comment_id
	 * @return
	 */
	int querlistnuk(String comment_id);

}
