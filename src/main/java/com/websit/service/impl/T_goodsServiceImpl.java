package com.websit.service.impl;
import com.websit.entity.T_goods;
import com.websit.mapper.T_goodsMapper;
import com.websit.service.IT_goodsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
@Service
public class T_goodsServiceImpl extends ServiceImpl<T_goodsMapper, T_goods> implements IT_goodsService {
	
	@Autowired
	private T_goodsMapper goodsMapper;

	@Override
	public List<T_goods> selectGoods(BigInteger id) {
		
		return goodsMapper.selectGoods(id);
	}

}
