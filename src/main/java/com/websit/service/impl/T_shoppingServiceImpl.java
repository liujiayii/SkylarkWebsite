package com.websit.service.impl;

import com.websit.entity.T_shopping;
import com.websit.mapper.T_shoppingMapper;
import com.websit.service.IT_shoppingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-17
 */
@Service
public class T_shoppingServiceImpl extends ServiceImpl<T_shoppingMapper, T_shopping> implements IT_shoppingService {

}
