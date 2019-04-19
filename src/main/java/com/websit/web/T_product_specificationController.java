package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.entity.T_product;
import com.websit.entity.T_product_specification;
import com.websit.entityvo.TproductSpecificationVo;
import com.websit.service.IT_productService;
import com.websit.service.IT_product_specificationService;
import com.websit.until.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 商品规格表(pc) 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-18
 */
@Controller
@RequestMapping("/t_product_specification")
public class T_product_specificationController {
	
	@Autowired
	private IT_product_specificationService specificationService;
	@Autowired
	private IT_productService productService;
	
	
	/**
	 * 查询价格
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/selectAllspecification", produces = "application/json; charset=utf-8")
	@ResponseBody
	
	public String selectAllspecification( String specificationName,Long product_id ) {
		//String c="{'尺寸'：39cm,'颜色'：红}";
		String str = null;
		T_product_specification product=new T_product_specification();
		product.setSpecificationName(specificationName);
		product.setProduct_id(product_id);
		System.out.println("product"+product);
		try {
			T_product_specification t=specificationService.selectAllspecification(product);
			
			if(t!=null) {
				System.out.println("价格"+t.getPrice());
				str=JsonUtil.getResponseJson(1, "查询成功", null, t.getPrice());
			}else {
				System.out.println("价格"+t);
				str=JsonUtil.getResponseJson(1, "无数据", null,null );
			}
			
			
		} catch (Exception e) {
			str=JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		
		
		return str;
		
	}
	

	/**
	 * 添加商品
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/addSpecificationService", produces = "application/json; charset=utf-8")
	@ResponseBody
	
	public String addSpecificationService(T_product_specification product_specification,T_product product) {
		
		String str = null;
		
		try {
			
			int a=productService.insertSpecificationService(product);
			
			
			//获取刚插入的id
			Long id=product.getId();
			product_specification.setProduct_id(id);
			
			boolean b=specificationService.insert(product_specification);
			
			if(a>0&&b==true) {
				str=JsonUtil.getResponseJson(1, "添加成功", null, null);
			}else {
				str=JsonUtil.getResponseJson(-1, "添加失败", null, null);
			}
			
		} catch (Exception e) {
			str=JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		
		
		return str;
		
	}
	
	
	
	

}
