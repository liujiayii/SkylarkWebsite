package com.websit.web;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.Inventory;
import com.websit.service.InventoryService;
import com.websit.until.JsonUtil;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	/**
	 * 查询商品库存---分页
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listAllInventoryById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listAllInventoryById(String productName, Integer page, Integer limit) {
		System.out.println("inventory" + productName+"page"+page+"limit");
		System.out.println("inventoryService.listAllInventoryById(page, limit, productName)"
				+ inventoryService.listAllInventoryById((page - 1) * limit, limit, productName));
		try {

			List<Inventory> result = inventoryService.listAllInventoryById((page - 1) * limit, limit, productName);
			inventoryService.findInventoryCount(productName);
			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", inventoryService.findInventoryCount(productName), result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", inventoryService.findInventoryCount(productName), result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 根据id删除库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@RequestMapping(value = "/deleteInventoryById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteInventoryById(BigInteger id) {
		try {
			int result = inventoryService.deleteInventoryById(id);

			if (result > 0) {
				return JsonUtil.getResponseJson(1, "删除成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "删除失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 修改商品库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@RequestMapping(value = "/updateInventory", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateInventory(int number, Long products_id, Long id) {
		System.out.println(number);
		Inventory inventory = new Inventory();
		inventory.setNumber(number);
		inventory.setProducts_id(products_id);
		inventory.setId(id);
		try {

			int result = inventoryService.updateInventory(inventory);

			if (result > 0) {
				return JsonUtil.getResponseJson(1, "修改成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

}
