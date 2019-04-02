package com.websit.mapper;
import com.websit.entity.T_revert;
import com.websit.entityvo.T_revertVo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品评论回复表（蔺） Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public interface T_revertMapper extends BaseMapper<T_revert> {
	/**
	 * @Title: seleceFirstRevert
	 * @description 通过评论表id查询回复评论
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	public List<T_revertVo> seleceFirstRevert(@Param("id")long id,@Param("page")Integer page,@Param("limit")Integer limit);
}
