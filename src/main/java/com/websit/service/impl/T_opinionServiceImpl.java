package com.websit.service.impl;

import com.websit.entity.T_opinion;
import com.websit.mapper.T_opinionMapper;
import com.websit.service.IT_opinionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 意见表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_opinionServiceImpl extends ServiceImpl<T_opinionMapper, T_opinion> implements IT_opinionService {
	
	@Autowired
	private T_opinionMapper opinionMapper;
	/**
	 * 增加一条意见
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */

	@Override
	public boolean insertOneOpinion(T_opinion opinion) {
		
		return opinionMapper.insertOneOpinion(opinion);
	}
	/**
	 * @description 查询所有意见
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	@Override
	public List<T_opinion> listAllOpinion(Integer star, Integer limit) {
		
		return opinionMapper.listAllOpinion(star, limit);
	}
	/**
	 * @description 查询所有意见条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	@Override
	public Integer findOpinionCount(T_opinion opinion) {
		
		return opinionMapper.findOpinionCount(opinion);
	}

}
