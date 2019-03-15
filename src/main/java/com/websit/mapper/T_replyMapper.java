package com.websit.mapper;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;

import java.util.List;
import java.util.Map;

import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 评论回复表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_replyMapper extends BaseMapper<T_reply> {
	List<postinglist>postinglist(String posting_id);
	List<postinglist> t_commentlist(String posting_id);
	public List<T_plateputing> tret(String posting_id);

}
