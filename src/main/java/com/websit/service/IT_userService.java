package com.websit.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.websit.entity.T_posting;
import com.websit.entity.T_reply;
import com.websit.entity.T_user;
import com.websit.entity.UserUpdateVo;
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

	/**
	 * 查询用户回帖数量
	 * @author pangchong
	 * @createDate 2019年3月18日 下午2:00
	 */
	public Integer selectUserReplyCountByUserId(T_reply reply);

	/**
	 * 查询用户总数量
	*@author lichangchun
	* @return
	*@return Long
	*@date 2019年3月19日    
	*
	 */
	public Long slectCount();

	
	/**
	 * 根据id查看用户发布的贴子
	 * @author pangchong
	 * @createDate 2019年3月19日 下午2:00
	 */
	public List<Personal> selectT_postingByUserId(BigInteger id,Integer page, Integer limit);

	public void insertWithPh(T_user t_user);
     /**
      * 
     *
      * @Title: updateUserVoById
     
      * @description 修改用户信息
     *
      * @param @param user
      * @param @return 
        
      * @return boolean    
     
      *
      * @author lishaozhang
      * @createDate 2019年3月22日
      */
	public boolean updateUserVoById(UserUpdateVo user);

	public List<Personal> selectT_postingByUserId(Integer id, Integer limit, Integer star);
	

}
