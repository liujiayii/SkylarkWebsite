package com.websit.service.impl;

import com.websit.entity.T_comment;
import com.websit.mapper.T_commentMapper;
import com.websit.service.IT_commentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_commentServiceImpl extends ServiceImpl<T_commentMapper, T_comment> implements IT_commentService {
	@Autowired
	public T_commentMapper T_commentMapper;
	@Override
	public int update(String id) {
		// TODO Auto-generated method stub
		return T_commentMapper.update(id);
	}

}
