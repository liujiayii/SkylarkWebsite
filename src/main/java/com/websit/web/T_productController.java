package com.websit.web;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.websit.entityvo.ProductTypeVo;
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

			ProductVo selectCount = productService.findBpiLists(productVo);
			Integer count = selectCount.getCount();

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
			inventory.setProduct_id(productVo.getId());
			// 增加商品时,增加库存
			int results = inventoryService.saveInventoryById(inventory);
			// //商品添加优惠
			discount.setProductId(productVo.getId());
			discountService.saveDiscountById(discount);

			// System.out.println("我去保存图片");
			String file = request.getParameter("file");
			System.out.println("file" + file);
			String result1[] = file.split(",");
			T_product_img product_img = new T_product_img();
			product_img.setProduct_id(productVo.getId());
			for (int i = 0; i < result1.length; i++) {
				product_img.setImg(result1[i]);
				productImgService.insert(product_img);
			}
			if (result > 0 && results > 0) {

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
	public String updateProduct(HttpServletRequest request, BigInteger productId, BigInteger id) {
		// System.out.println("==l来啦===");
		int deleteProductImageByProductId = productImgService.deleteProductImageByProductId(productId);
		try {
			ProductVo productVo = new ProductVo();
			String file = request.getParameter("file");
			// String productId = request.getParameter("productId");
			String productName = request.getParameter("productName");
			String producttypeid = request.getParameter("producttypeid");
			String image = request.getParameter("image");
			//String price = request.getParameter("price");
			String state = request.getParameter("state");
			String brand = request.getParameter("brand");
			String describion = request.getParameter("describion");
			String zoneid = request.getParameter("zoneid");
			String after_information = request.getParameter("after_information");
			// System.out.println(productName);
			productVo.setId(Long.parseLong(productId + ""));
			productVo.setProductName(productName);
			productVo.setProducttypeid(Long.parseLong(producttypeid));
			productVo.setImage(image);
			productVo.setState(Integer.valueOf(state));
			productVo.setBrand(brand);
			productVo.setDescribion(describion);
			productVo.setZoneid(Long.parseLong(zoneid));
			productVo.setAfter_information(after_information);
			// System.out.println(zoneid);
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

			int result = productService.updateProduct(productVo);

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
			System.out.println("productId"+productId);
			List<ProductDetails> result = productService.listProductByProductId(productId);
System.out.println("result"+result);
			if (result.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, result);
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
	 * @author xxxxx
	 * @createDate 2019年3月24日 下午2:00
	 */
	@RequestMapping(value = "/listProductByProductTypeId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByProductTypeId(String productName, Integer page, Integer limit) {
		try {

			List<ProductVo> result = productService.listProductByProductTypeId(productName, (page - 1) * limit, limit);
			List<ProductVo> result1 = productService.listProductByCount(productName, (page - 1) * limit, limit);
			System.out.println("result" + result.size());
			if (result.size() >= 1 && result1.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", result1.get(0).getCount(), result);

			} else {
				System.out.println("*****");
				return JsonUtil.getResponseJson(1, "无数据", result1.get(0).getCount(), result);
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

	/**
	 * 根据类型id查询当前商品种类及每个种类下所有商品
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listProductByType", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByType(@RequestParam(value = "productTypeId", required = false) String productTypeId,
			String page, String limit) {
		Long productTypeIds = null;

		if (StringUtils.isNotEmpty(productTypeId)) {
			productTypeIds = Long.valueOf(productTypeId);
		}

		return productService.listProductByTypeId(productTypeIds, 1, 10);

	}
	
	/**
	 * 根据大分类id查询大分类下所有商品
	 *
	 * @Title: listProductByClassTypeId
	 * @description 
	 * @param classification_id
	 * @param page
	 * @param limit
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年4月17日-下午4:48:34
	 */
	@RequestMapping(value = "/listProductByClassTypeId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByClassTypeId(Long classification_id, Integer page, Integer limit) {
		List<ProductTypeVo> listProduct = null;
		int code = ReturnCode.SUCCSEE_CODE;
		// 总条数
		int count = 0;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		page = (page <= 0) ? 1 : limit * (page - 1);
		
		if (classification_id == null || page == null || limit == null) {
			return JsonUtil.getResponseJson(0, "参数缺失", null, null);
		}
		
		try {
			listProduct = productService.listProductByClassTypeId(classification_id, page, limit);
			count = productService.listProductByClassTypeId(classification_id, null, null).size();
			if (listProduct == null || listProduct.size() == 0) {
				msg = ReturnCode.NORESULT_SELECT_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = ReturnCode.EXCEPTION_CODE;
			msg = ReturnCode.FAILED_SELECT_MSG;
		}
		
		return JsonUtil.getResponseJson(code, msg, count, listProduct);
	}
	
	/**
	 * 根据商品id查询商品详情(后台)
	 * 
	 * @author xxxxx
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/listProductByProductIds", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByProductIds(BigInteger productId) {
         Map<String , Object> map = new HashMap<>();
         Discount s1 = 	null;
		try {
			List<ProductDetails> result = productService.listProductByProductIds(productId);
			if (productId != null) {
				s1 = 	discountService.selectDiscountListByProductId(productId);
			}
			
			if (result.size() >0) {
				map.put("result", result.get(0));
				map.put("s1", s1);
				return JsonUtil.getResponseJson(1, "查看成功", null, map);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
	
	/**
	 * 首页模糊查询(后台)
	 * 
	 * @author xxxxx
	 * @createDate 2019年3月24日 下午2:00
	 */
	@RequestMapping(value = "/listProductByProductTypeIds", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listProductByProductTypeIds(String productName, Integer page, Integer limit) {
		try {

			List<ProductVo> result = productService.listProductByProductTypeIds(productName, (page - 1) * limit, limit);
			List<ProductVo> result1 = productService.findproductCountAll(productName, (page - 1) * limit, limit);
			System.out.println("result" + result.size());
			if (result.size() >= 1 && result1.size() >= 1) {
				return JsonUtil.getResponseJson(1, "查看成功", result1.get(0).getCount(), result);

			} else {
				System.out.println("*****");
				return JsonUtil.getResponseJson(1, "无数据", result1.get(0).getCount(), result);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
