package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_discount;
import com.websit.service.IT_discountService;
import com.websit.until.JsonUtil;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 商品优惠表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
@Controller
public class T_discountController {
	
	@Autowired
	private IT_discountService discountService;
	/**
	 * 添加商品优惠
	 * @param discount
	 * @return 
	 */
	@RequestMapping("/addDiscount")
	@ResponseBody
	public String insertDiscount(T_discount discount){
		String res;
		try{
			boolean num = discountService.insertOrUpdateAllColumn(discount);
			if(num){
				res = JsonUtil.getResponseJson(1, "添加成功", null, null);
			}else{
				res = JsonUtil.getResponseJson(1, "添加失败", null, null);
			}
		}catch(Exception e){
			res = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		
		return res;
	}
	/**
	 * 修改优惠
	 * @param discount
	 * @return
	 */
	@RequestMapping("/updateDiscount")
	@ResponseBody
	public String updateDiscount(T_discount discount){

		String res;
		try {
			boolean num = discountService.updateById(discount);
			if(num){
				res = JsonUtil.getResponseJson(1, "修改成功", null, null);
			}else{
				res = JsonUtil.getResponseJson(-1, "修改失败", null, null);
			}
		} catch (Exception e) {
			res = JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return res;
	}
	/**
	 * 删除优惠
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteDiscount")
	@ResponseBody
	public String deleteDiscount(Long id){
		String res;
		try {
			boolean num = discountService.deleteById(id);
			if(num){
				res = JsonUtil.getResponseJson(1,"删除成功", null, null);
			}else{
				res = JsonUtil.getResponseJson(-1,"删除失败", null, null);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = JsonUtil.getResponseJson(-1,"系统异常", null, null);
			
		}
		
		return res;
	}
	/**
	 * 查询所有优惠  不分页
	 * @return
	 */
	@RequestMapping("/findAllDiscont")
	@ResponseBody
	public String selectList(){
		String res;
		try {
			List<T_discount> discountList = discountService.selectList();
			if(discountList !=null){
				res = JsonUtil.getResponseJson(1, "查询成功", null, discountList);
			}else{
				res = JsonUtil.getResponseJson(-1, "查询失败", null, null);
			}
		} catch (Exception e) {
			res = JsonUtil.getResponseJson(-1, "查询失败", null, null);
			
		}
		
		return res;
	}
	/**
	 * 查询所有分页
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/pageOfDiscount")
	@ResponseBody
	public String pageOfDiscount(Integer page,Integer limit){
	
		try {
			Integer start = (page-1) * limit;
			List<T_discount> discountPageList = discountService.pageOfDiscount(start,limit);
			Integer count = discountService.selectCoount();
			
			System.out.println("总数："+count);
			if(discountPageList.size() >=1){
				return JsonUtil.getResponseJson(1, "查询成功", count, discountPageList);
			}else{
				return JsonUtil.getResponseJson(-1, "查询失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		
	}
}
