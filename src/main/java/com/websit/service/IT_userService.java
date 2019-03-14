package com.websit.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entity.T_user;
import com.websit.entityvo.Personal;

/**
 * <p>
 * 前台用户表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_userService extends IService<T_user> {
	/**
	 * 根据id查看个人详情资料
	 * @author pangchong
	 * @createDate 2019年3月13日 下午2:00
	 */
	public List<Personal> selectUserById(Personal personal);

}
