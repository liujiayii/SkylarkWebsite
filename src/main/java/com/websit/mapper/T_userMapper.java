package com.websit.mapper;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_posting;
import com.websit.entity.T_reply;
import com.websit.entity.T_user;
import com.websit.entity.UserUpdateVo;
import com.websit.entityvo.Personal;


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
	public List<Personal> selectUserById(BigInteger id);
	
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
	 * 1.1个人资料中，查询用户回帖数量
	 * @author pangchong
	 * @createDate 2019年3月18日 下午2:00
	 */
	public Integer selectUserReplyCountByUserId(T_reply reply);
	
	/**
	 * 1.2个人资料中，查询用户发过的主题数量
	 * @author dujiawei
	 * @createDate 2019年6月5日 
	 */
	public Integer selectUserPostingCountByUserId(T_reply reply);

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
	//public List<Personal> selectT_postingByUserId(@Param("id") BigInteger id,@Param("page") Integer page, @Param("limit") Integer limit);
    /**
     * 
    *
     * @Title: insertWithPh
    
     * @description 增加用户
    *
     * @param @param t_user 
       
     * @return void    
    
     *
     * @author lishaozhang
     * @createDate 2019年3月20日
     */
	public void insertWithPh(T_user t_user);
    
	/**
	 * 
	*
	 * @Title: updateUserVoById
	
	 * @description 用户信息修改
	*
	 * @param @param user
	 * @param @return 
	   
	 * @return Integer    
	
	 *
	 * @author lishaozhang
	 * @createDate 2019年3月22日
	 */
	public Integer updateUserVoById(UserUpdateVo user);

	public List<Personal> selectT_postingByUserId(@Param("id") Integer id, @Param("page")Integer page, @Param("limit")Integer limit);


}
