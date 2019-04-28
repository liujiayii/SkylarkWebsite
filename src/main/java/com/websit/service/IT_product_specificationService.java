package com.websit.service;

import com.websit.entity.T_product_specification;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品详情表(pc) 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
public interface IT_product_specificationService extends IService<T_product_specification> {

	
	public T_product_specification selectAllspecification(T_product_specification t);
	public T_product_specification specification(String product_id,String specifications);
}
