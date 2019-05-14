package com.websit.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.Inventory;

public interface InventoryMapper {
	/**
	 * @description 查询库存 --- 分页
	 * @param
	 * @author pangchong
	 * @createDate 2019年3月23日
	 */
	public List<Inventory> listAllInventoryById(@Param("page") Integer star, @Param("limit") Integer limit,
			@Param("productName") String productName);

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
	public Integer findInventoryCount(@Param("productName")String productName);

	/**
	 * description 根据商品规格id删除库存
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteInventoryByProductSpecificationId(@Param("attribute") Long attribute);
	/**
	 * description 根据规格id查询库存
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public Integer listInventoryById(@Param("attribute")Long attribute,@Param("product_id")Long product_id);
	
	

}
