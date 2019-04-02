package com.websit.service;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.websit.entityvo.T_replylist;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 评论回复表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_replyService extends IService<T_reply> {
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<postinglist> postingli(String id,RowBounds RowBounds);
	/**
	 * 
	 * @param posting_id
	 * @return
	 */
	 int updime(String posting_id);
	/**
	 * 
	 * 查询标题以及帖子
	 */
	List<T_plateputing> tret(String posting_id);
	/**
	 * 
	 * 查询评论数据
	 * 
	 */
	List<T_replylist> T_replylist(String comment_id,RowBounds RowBounds);
	/**
	 * 
	 * @param posting_id
	 * @return
	 */
	 int upnumber(String posting_id);
		/**
		 * 
		 * @param posting_id
		 * @return
		 */
		 int querlist(String posting_id);
			/**
			 * 查询回复的回复总数量
			 * @param comment_id
			 * @return
			 */
			int querlistnuk(String comment_id);
	
	
}
