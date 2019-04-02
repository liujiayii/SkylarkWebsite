package com.websit.service.impl;

import com.websit.entity.T_revert;
import com.websit.entityvo.T_revertVo;
import com.websit.mapper.T_revertMapper;
import com.websit.mapper.T_reviewMapper;
import com.websit.service.IT_revertService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评论回复表（蔺） 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_revertServiceImpl extends ServiceImpl<T_revertMapper, T_revert> implements IT_revertService {
	@Autowired
	private T_revertMapper t_revertMapper;
	/**
	 * @Title: seleceFirstRevert
	 * @description 通过评论表id查询回复评论
	 * @param @param t_reviewVo
	 * @param @return    
	 * @return T_reviewVo    
	 * @author linhongyu
	 * @createDate 2019年3月22日
	 */
	@Override
	public List<T_revertVo> seleceFirstRevert(long id,Integer page,Integer limit) {
		// TODO Auto-generated method stub
		return t_revertMapper.seleceFirstRevert(id,page,limit);
	}

}
