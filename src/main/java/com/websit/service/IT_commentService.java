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

}
