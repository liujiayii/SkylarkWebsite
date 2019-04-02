package com.websit.service;

import com.websit.entity.T_opinion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 意见表 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface IT_opinionService extends IService<T_opinion> {
	
	/**
	 * 增加一条意见
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	boolean  insertOneOpinion(T_opinion opinion);
	/**
	 * @description 查询所有意见
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	public List<T_opinion> listAllOpinion(@Param("star") Integer star, @Param("limit") Integer limit);
	/**
	 * @description 查询所有意见条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	Integer findOpinionCount(T_opinion opinion);


}
