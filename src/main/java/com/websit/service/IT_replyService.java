package com.websit.service;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;

import java.util.List;
import java.util.Map;

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
	List<postinglist> postingli(String id);
	List<postinglist> t_commentlist(String posting_id);
	List<T_plateputing> tret(String posting_id);
}
