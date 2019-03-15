package com.websit.mapper;

import com.websit.entity.T_user;
import com.websit.entityvo.Personal;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;


/**
 * <p>
 * 前台用户表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Mapper
public interface T_userMapper extends BaseMapper<T_user> {

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
