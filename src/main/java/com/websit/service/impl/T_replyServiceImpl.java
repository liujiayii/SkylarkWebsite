package com.websit.service.impl;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.websit.mapper.T_postingMapper;
import com.websit.mapper.T_replyMapper;
import com.websit.service.IT_replyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论回复表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_replyServiceImpl extends ServiceImpl<T_replyMapper, T_reply> implements IT_replyService {

	@Autowired
	private T_replyMapper T_replyMapper;
	public List<postinglist> postingli(String id) {	
		
		return T_replyMapper.postinglist(id);
	}
	public List<postinglist> t_commentlist(String posting_id){
		return T_replyMapper.t_commentlist(posting_id);
	}
	@Override
	public List<T_plateputing> tret(String posting_id) {
		
		 return T_replyMapper.tret(posting_id);
	}

}
