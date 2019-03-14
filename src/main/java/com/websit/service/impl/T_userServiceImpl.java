package com.websit.service.impl;

import com.websit.entity.T_user;
import com.websit.entityvo.Personal;
import com.websit.mapper.T_userMapper;
import com.websit.service.IT_userService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 前台用户表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_userServiceImpl extends ServiceImpl<T_userMapper, T_user> implements IT_userService {
	@Autowired
	private T_userMapper userMapper;
	/**
	 * 根据id查看个人详情资料
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
	@Override
	public List<Personal> selectUserById(Personal personal) {
	
		return userMapper.selectUserById(personal);
	}

}
