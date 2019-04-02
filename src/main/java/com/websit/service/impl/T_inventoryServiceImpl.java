package com.websit.service.impl;

import com.websit.entity.T_inventory;
import com.websit.mapper.T_inventoryMapper;
import com.websit.service.IT_inventoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_inventoryServiceImpl extends ServiceImpl<T_inventoryMapper, T_inventory> implements IT_inventoryService {

}
