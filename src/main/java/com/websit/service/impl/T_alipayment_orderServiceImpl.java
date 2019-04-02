package com.websit.service.impl;

import com.websit.entity.T_alipayment_order;
import com.websit.mapper.T_alipayment_orderMapper;
import com.websit.service.IT_alipayment_orderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户支付宝订单 服务实现类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-03-27
 */
@Service
public class T_alipayment_orderServiceImpl extends ServiceImpl<T_alipayment_orderMapper, T_alipayment_order> implements IT_alipayment_orderService {

	/**
	 * 通过商户订单号查询商户订单
	 *
	 * @Title: selectByOutTradeNo
	 * @description
	 * @param outTradeNo
	 * @return AlipaymentOrder
	 * @author lujinpeng
	 * @createDate 2019年3月25日-下午5:46:33
	 */
	@Override
	public T_alipayment_order selectByOutTradeNo(String order_no) {
		EntityWrapper<T_alipayment_order> wrapper = new EntityWrapper<>();
		wrapper.eq("out_trade_no", order_no);

		return new T_alipayment_order().selectOne(wrapper);

	}

	/**
	 * 更新交易表中状态
	 *
	 * @Title: updateByPrimaryKey
	 * @description
	 * @return int
	 * @author lujinpeng
	 * @createDate 2019年3月25日-下午6:15:03
	 */
	@Override
	public int updateByPrimaryKey(T_alipayment_order alipaymentOrder) {
		
		return alipaymentOrder.updateById() ? 1 : 0;
	}

	/**
	 * 创建新的商户支付宝订单
	 *
	 * @Title: createAlipayMentOrder
	 * @description 
	 * @param alipaymentOrder
	 * @return  
	 * boolean    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-上午11:50:51
	 */
	@Override
	public boolean createAlipayMentOrder(T_alipayment_order alipaymentOrder) {
		
		return alipaymentOrder.insert();
	}

	
	
}
