package com.websit.service;

import java.util.Date;
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
	
	/**
	 * 根据用户id查询会员天数
	 * @author pangchong
	 * @createDate 2019年3月15日 下午2:00
	 */
	public String selectUserDayById(Personal personal);
	
	/**
	 * 根据用户id查询注册时间
	 * @author pangchong
	 * @createDate 2019年3月15日 下午2:00
	 */
	public Date selectUserCreateTimeById(Personal personal);

}
