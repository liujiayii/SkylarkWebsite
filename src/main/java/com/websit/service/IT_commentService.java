package com.websit.service;

import com.websit.entity.T_comment;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_commentService extends IService<T_comment> {
	/**
	 * 更新回复发帖的时间
	 */
	public int  update(String id);

	/**
	 * @Title: deleteCommentByPostingId
	 * @description 根据帖子id删除回复信息
	 * @param t_comment
	 * @return int    
	 * @author dujiawei
	 * @createDate 2019年6月5日
	 */
	public int deleteCommentByPostingId(T_comment t_comment);

}
