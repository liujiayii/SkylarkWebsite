package com.websit.service.impl;

import com.websit.entity.T_dynamic;
import com.websit.entityvo.T_dynamicVo;
import com.websit.mapper.T_dynamicMapper;
import com.websit.service.IT_dynamicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司动态表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-02
 */
@Service
public class T_dynamicServiceImpl extends ServiceImpl<T_dynamicMapper, T_dynamic> implements IT_dynamicService {
	@Autowired
	private T_dynamicMapper t_dynamicMapper;

	/**
	 * @Title: SelectAllDy
	 * @description 查询所有动态
	 * @param @param t_dynamic
	 * @param @return    
	 * @return List<T_dynamic>    
	 * @author linhongyu
	 * @createDate 2019年4月3日
	 */
	@Override
	public List<T_dynamicVo> SelectAllDy(T_dynamicVo t_dynamic) {
		return t_dynamicMapper.SelectAllDy(t_dynamic);
	}

}
