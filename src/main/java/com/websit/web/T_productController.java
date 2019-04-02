package com.websit.web;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.websit.constant.ReturnCode;
import com.websit.entity.Inventory;
import com.websit.entity.T_product_img;
import com.websit.entityvo.Discount;
import com.websit.entityvo.ProductDetails;
import com.websit.entityvo.ProductVo;
import com.websit.service.IT_discount_productService;
import com.websit.service.IT_productService;
import com.websit.service.IT_product_imgService;
import com.websit.service.InventoryService;
import com.websit.service.ZoneService;
import com.websit.until.JsonUtil;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Controller
public class T_productController {

	@Autowired
	private IT_productService productService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private IT_discount_productService discountService;

	@Autowired
	private IT_product_imgService productImgService;
	@Autowired
	private ZoneService zoneService;

	/**
	 * 根据类型id查询当前商品种类及每个种类下所有商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listProductByTypeId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByTypeId(@RequestParam(value = "productTypeId", required = false) String productTypeId,
			String page, String limit) {
		Long productTypeIds = null;

		if (StringUtils.isNotEmpty(productTypeId)) {
			productTypeIds = Long.valueOf(productTypeId);
		}
		Integer limits = null;
		if (StringUtils.isEmpty(page)) {
			page = "1";
		}
		if (StringUtils.isNotEmpty(limit)) {
			limits = Integer.valueOf(limit);
		} else {
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, "参数缺失", null, null);
		}
		return productService.listProductByTypeId(productTypeIds, Integer.valueOf(page), limits);

	}

	/**
	 * 查询商品---分页
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listAllProductById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listAllProductById(Integer page, Integer limit, ProductVo productVo) {
		try {
			
			productVo.setPage((page - 1) * limit);
			productVo.setLimit(limit);
			// Integer star = (page - 1) * limit;
			List<ProductVo> result = productService.listAllProductById(productVo);
			// System.out.println(result);
			ProductVo selectCount = productService.findBpiLists(productVo);
			Integer count = selectCount.getCount();
			// System.out.println(count);
			if (result.size() >= 1 && count != null) {
				return JsonUtil.getResponseJson(1, "查看成功", count, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 增加商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/saveProduct", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveProduct(ProductVo productVo, Inventory inventory, Discount discount, HttpServletRequest request) {
		try {

			int result = productService.saveProduct(productVo);
			inventory.setProducts_id(productVo.getId());
			// 增加商品时,增加库存
			int results = inventoryService.saveInventoryById(inventory);
			// //商品添加优惠
			discount.setProductid(productVo.getId());
			discountService.saveDiscountById(discount);
			
			// System.out.println("我去保存图片");
			String file = request.getParameter("file");
			System.out.println("file"+file);
			String result1[] = file.split(",");
			T_product_img product_img = new T_product_img();
			product_img.setProduct_id(productVo.getId());
			for (int i = 0; i < result1.length; i++) {
				product_img.setImg(result1[i]);
				productImgService.insert(product_img);
			}
			if (result > 0 && results > 0) {
				System.out.println("----------------------//////////");
				return JsonUtil.getResponseJson(1, "增加成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 修改商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/updateProduct")
	@ResponseBody
	public String updateProduct(HttpServletRequest request,BigInteger productId,BigInteger id) {
		//System.out.println("==l来啦===");
		int deleteProductImageByProductId = productImgService.deleteProductImageByProductId(productId);
		try {
			ProductVo productVo = new ProductVo();
		/*	Long id1 = null;
			if(productVo.getZoneid() == id1){
				System.out.println("id1+++++:"+id1);
		zoneService.selectZoneByProductId(id);
			}*/
			String file = request.getParameter("file");
		//	String productId = request.getParameter("productId");
			String productName = request.getParameter("productName");
			String producttypeid = request.getParameter("producttypeid");
			String image = request.getParameter("image");
			String price = request.getParameter("price");
			String color = request.getParameter("color");
			String state = request.getParameter("state");
			String brand = request.getParameter("brand");
			String specifications = request.getParameter("specifications");
			String describion = request.getParameter("describion");
			String zoneid = request.getParameter("zoneid");
		//	System.out.println(productName);
			productVo.setId(Long.parseLong(productId+""));
			productVo.setProductName(productName);
			productVo.setProducttypeid(Long.parseLong(producttypeid));
			productVo.setImage(image);
			productVo.setPrice(new BigDecimal(price));
			productVo.setColor(color);
			productVo.setState(Integer.valueOf(state));
			productVo.setBrand(brand);
			productVo.setSpecifications(specifications);
			productVo.setDescribion(describion);
			 productVo.setZoneid(Long.parseLong(zoneid));
            //System.out.println(zoneid);
			// productImgService.deleteImgById(productVo.getId());
			String result1[] = file.split(",");
			T_product_img product_img = new T_product_img();
			product_img.setProduct_id(productVo.getId());
			for (int i = 0; i < result1.length; i++) {
				product_img.setImg(result1[i]);
				productImgService.insert(product_img);
			}
			product_img.getProduct_id();
			productImgService.updateAllColumnById(product_img);
			System.out.println(productVo);
			int result = productService.updateProduct(productVo);
			System.out.println(result);
			if (result > 0) {
				return JsonUtil.getResponseJson(1, "修改成功", null, result);
			} else {
				return JsonUtil.getResponseJson(-2, "无数据", null, null);
			}
			// return null;
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 修改状态(上架/下架)
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/updateProductState", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateProductState(ProductVo productVo) {
		try {
			int result = productService.updateProductState(productVo);
			if (result > 0) {
				return JsonUtil.getResponseJson(1, "修改状态成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 根据商品id查询商品详情
	 * 
	 * @author pangchongdsb
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listProductByProductId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByProductId(BigInteger productId) {
		try {
	        List<ProductDetails> result = productService.listProductByProductId(productId);

			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 根据id删除商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/deleteProductById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteProductById(BigInteger id) {
		try {
			boolean result = productService.deleteById(id);
			if (result) {
				return JsonUtil.getResponseJson(1, "删除成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}

	/**
	 * 首页模糊查询
	 * 
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@RequestMapping(value = "/listProductByProductTypeId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByProductTypeId(String productName) {
		try {

			List<ProductVo> result = productService.listProductByProductTypeId(productName);

			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
	
	@RequestMapping("/pageOfProductByState")
	@ResponseBody
	public String listProductByProductState(Integer page, Integer limit) {
		String res;
		try {
			Integer start = (page - 1) * limit;
			List<ProductVo> productVoList = productService.pageOfProductState(start, limit);
			Integer count = productService.selectCountByState();
			if (!productVoList.isEmpty()) {
				res = JsonUtil.getResponseJson(1, "查询成功", count, productVoList);

			} else {
				res = JsonUtil.getResponseJson(-1, "暂无数据", null, null);

			}
		} catch (Exception e) {
			e.printStackTrace();
			res = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return res;
	}
}
