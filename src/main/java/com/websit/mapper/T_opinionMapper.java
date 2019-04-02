package com.websit.mapper;

import com.websit.entity.T_opinion;
import com.websit.entityvo.Personal;
import com.websit.entityvo.ProductVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 意见表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_opinionMapper extends BaseMapper<T_opinion> {
	
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
