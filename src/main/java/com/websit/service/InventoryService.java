package com.websit.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.Inventory;

public interface InventoryService {
	/**
	 * @description 查询库存 --- 分页
	 * @param
	 * @author pangchong
	 * @createDate 2019年3月23日
	 */
	public List<Inventory> listAllInventoryById(Integer star, Integer limit, String Inventory);

	/**
	 * 根据商品id增加库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int saveInventoryById(Inventory inventory);

	/**
	 * 修改库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int updateInventory(Inventory inventory);

	/**
	 * 查询库存条数
	 * 
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public Integer findInventoryCount(String inventory);

	/**
	 * description 根据商品规格id删除库存
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteInventoryByProductSpecificationId(@Param("attribute") Long attribute);
	/**根据规格id
	 * 查询库存
	 * @param attribute
	 * @return
	 */
	public Integer listInventoryById(Long attribute,Long product_id);

}
