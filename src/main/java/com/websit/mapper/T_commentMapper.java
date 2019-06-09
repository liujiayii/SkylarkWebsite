package com.websit.mapper;

import com.websit.entity.T_comment;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_commentMapper extends BaseMapper<T_comment> {
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
