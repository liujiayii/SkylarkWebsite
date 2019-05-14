package com.websit.service.impl;

import com.websit.entity.T_plate;
import com.websit.entity.T_reply;
import com.websit.entityvo.T_plateputing;
import com.websit.entityvo.postinglist;
import com.websit.mapper.T_postingMapper;
import com.websit.mapper.T_replyMapper;
import com.websit.service.IT_replyService;
import com.websit.until.fileuiil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websit.entityvo.T_replylist;

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
	public List<postinglist> postingli(String id,RowBounds RowBounds) {	
		List<postinglist> tre=T_replyMapper.postinglist(id, RowBounds);
		fileuiil  fileuiil=new fileuiil();
		for(int  i=0;i<tre.size();i++) {
			String text=fileuiil.readTxt(tre.get(i).getComment());
			
			tre.get(i).setComment(text);
		}
//		System.out.println(tre.toString()+"1111111111111111111111111111111111111111111111");
		return tre;
	}
	
	@Override
	public List<T_plateputing> tret(String posting_id) {
		List<T_plateputing> tre=T_replyMapper.tret(posting_id);
		fileuiil  fileuiil=new fileuiil();
		for(int  i=0;i<tre.size();i++) {
			String text=fileuiil.readTxt(tre.get(i).getContext());
			
			tre.get(i).setContext(text);
		}
//		System.out.println(tre.toString()+"2222222222222222222222222222222222222222222");
		 return tre;
	}
	@Override
	public List<T_replylist> T_replylist(String comment_id,RowBounds RowBounds) {
		List<T_replylist> tre=T_replyMapper.T_replylist(comment_id,RowBounds);
//		for(int  i=0;i<tre.size();i++) {
//			String text=fileuiil.readTxt(tre.get(i).getResponse());
//			
//			tre.get(i).setResponse(text);
//		}
//		 
		return tre;
	}

	@Override
	public int updime(String comment_id) {
		// TODO Auto-generated method stub
		 return T_replyMapper.updime(comment_id);
	}

	@Override
	public int upnumber(String posting_id) {
		// TODO Auto-generated method stub
		return T_replyMapper.number(posting_id);
	}

	@Override
	public int querlist(String posting_id) {
		// TODO Auto-generated method stub
		return T_replyMapper.querlist(posting_id);
	}

	@Override
	public int querlistnuk(String comment_id) {
	
		return T_replyMapper.querlistnuk(comment_id);
	}

}
