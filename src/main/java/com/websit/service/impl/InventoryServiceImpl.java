package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.Inventory;
import com.websit.mapper.InventoryMapper;
import com.websit.service.InventoryService;
@Service
public class InventoryServiceImpl implements InventoryService{
@Autowired
private InventoryMapper inventoryMapper;
/**
 * @description 查询库存 --- 分页
 * @param 
 * @author pangchong
 * @createDate 2019年3月23日
 */
@Override
public List<Inventory> listAllInventoryById(Integer page, Integer limit,String productName) {

	return inventoryMapper.listAllInventoryById(page, limit,productName);
}
/**
 * 根据商品id增加库存
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int saveInventoryById(Inventory inventory) {
	
	return inventoryMapper.saveInventoryById(inventory);
}
/**
 * 修改库存
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int updateInventory(Inventory inventory) {

	return inventoryMapper.updateInventory(inventory);
}
/**
 * 查询库存条数
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public Integer findInventoryCount(Inventory inventory) {
	
	return inventoryMapper.findInventoryCount(inventory);
}
/**
 * description   根据id删除库存
 *
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */

@Override
public int deleteInventoryById(BigInteger id) {
	
	return inventoryMapper.deleteInventoryById(id);
}






}
