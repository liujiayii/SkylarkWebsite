package com.websit.service.impl;

import com.websit.entity.T_user;
import com.websit.entityvo.Personal;
import com.websit.mapper.T_userMapper;
import com.websit.service.IT_userService;
import com.websit.until.JsonUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	/**
	 * 根据用户id查询会员天数
	 * @author pangchong
	 * @createDate 2019年3月15日 下午2:00
	 */
	@SuppressWarnings("unused")
	@Override
	public String selectUserDayById(Personal personal) {
		try {
			//将字符串转为日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date dstr = userMapper.selectUserCreateTimeById(personal);
			//String dstr="2008-08-08 08:08:08 ";
			//Date date=sdf.parse(dstr);
			long s1=dstr.getTime();//将时间转为毫秒
			long s2=System.currentTimeMillis();//得到当前的毫秒
			long day=(s2-s1)/1000/60/60/24;
			System.out.println("该用户注册了"+day+"天，你得抓紧时间行动了" );
			if (dstr != null) {
				//System.out.println(day);
				return JsonUtil.getResponseJson(1, "查看成功", null, day);
			} 
		
		} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		return userMapper.selectUserDayById( personal);

	}
	/**
	 * 根据用户id查询注册时间
	 * @author pangchong
	 * @createDate 2019年3月15日 下午2:00
	 */
	@Override
	public Date selectUserCreateTimeById(Personal personal) {
	
		return userMapper.selectUserCreateTimeById(personal);
	}
	

}
