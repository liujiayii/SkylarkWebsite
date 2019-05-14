package com.websit.web;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.Inventory;
import com.websit.entity.T_discount_product;
import com.websit.entity.T_product;
import com.websit.entity.T_product_specification;
import com.websit.entity.T_specifications;
import com.websit.entityvo.IOSProductData;
import com.websit.entityvo.Name;
import com.websit.entityvo.ProductVo;
import com.websit.entityvo.SpecificationsVo;
import com.websit.entityvo.StockVo;
import com.websit.mapper.T_product_specificationMapper;
import com.websit.service.IT_discount_productService;
import com.websit.service.IT_orderService;
import com.websit.service.IT_productService;
import com.websit.service.IT_product_specificationService;
import com.websit.service.IT_specificationsService;
import com.websit.service.InventoryService;
import com.websit.service.SpecificationsService;
import com.websit.until.JsonUtil;
import com.websit.until.Security;

import net.sf.json.JSONArray;

/**
 * <p>
 * 商品规格表(pc) 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
@Controller

public class T_product_specificationController {

	@Autowired
	private IT_product_specificationService specificationService;
	@Autowired
	private IT_productService productService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private T_product_specificationMapper specificationMapper;
	@Autowired
	private IT_discount_productService discount_productService;
	@Autowired
	private IT_orderService IT_orderService;

	@Autowired
	private IT_specificationsService specificationsService;

	String astring;
	String bstring;

	/**
	 * 查询价格、库存
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/selectAllspecification", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String selectAllspecification(String specificationName, Long product_id) {
		// String c="{'尺寸'：39cm,'颜色'：红}";
		String str = null;
		T_product_specification product = new T_product_specification();
		product.setSpecificationName(specificationName);
		product.setProduct_id(product_id);
		//System.out.println("product" + product);
		Inventory nventory = new Inventory();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			T_product_specification t = specificationService.selectAllspecification(product);

			if (t != null) {
				System.out.println("价格" + t.getPrice());
				nventory.setAttribute(t.getId());

				Integer number = inventoryService.listInventoryById(t.getId(), product_id);
				map.put("number", number);
				map.put("price", t.getPrice());
				str = JsonUtil.getResponseJson(1, "查询成功", null, map);
			} else {
				//System.out.println("价格" + t);
				str = JsonUtil.getResponseJson(1, "无数据", null, null);
			}

		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return str;

	}

	/**
	 * 添加商品 同时添加满减
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/addproductService", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String addSpecificationService(
			/* T_product_specification product_specification, */ProductVo product, Long discount_id) {

		String str = null;

		try {
			//System.out.println("product" + product);
			int a = productService.insertSpecificationService(product);

			Long id = product.getId();
			T_discount_product tt = new T_discount_product();
			tt.setProduct_id(id);
			tt.setDiscount_id(discount_id);
			boolean c = discount_productService.insert(tt);
			if (a > 0 && c == true) {
				str = JsonUtil.getResponseJson(1, "添加成功", null, id);
			} else {
				str = JsonUtil.getResponseJson(-1, "添加失败", null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			str = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return str;

	}

	/**
	 * 添加规格
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/addSpecificationService", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String addSpecificationService(T_product_specification product_specification, Integer number) {

		String str = null;

		Inventory t = new Inventory();

		//System.out.println("product_specificatio" + product_specification);
		try {
			t.setNumber(number);
			t.setProduct_id(product_specification.getProduct_id());

			boolean b = specificationService.insert(product_specification);
			t.setAttribute(product_specification.getId());
			int c = inventoryService.saveInventoryById(t);

			if (b == true && c > 0) {
				str = JsonUtil.getResponseJson(1, "添加成功", null, null);
			} else {
				str = JsonUtil.getResponseJson(-1, "添加失败", null, null);
			}

		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return str;

	}

	/**
	 * 根据商品id查询所有的规格属性以及包含的值
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/selectAllspecificationValue", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String selectAllspecificationValue(String product_id) {
		// String c="{'尺寸'：39cm,'颜色'：红}";
		String str = null;

		Map<String, String> map = new HashMap<String, String>();
		Map<String, List<String>> maps = new HashMap<String, List<String>>();
		List<String> lists = new ArrayList<String>();
		List<Map<String, List<String>>> listss = new ArrayList<Map<String, List<String>>>();

		try {

			List<T_product_specification> list = specificationMapper.selectlstspecification(product_id);
			//System.out.println("list" + list);
			for (int a = 0; a < list.size(); a++) {
				String st = list.get(a).getSpecificationName().substring(1,
						(list.get(a).getSpecificationName().length() - 1));
				String[] sz = st.split(",");
				for (int b = 0; b < sz.length; b++) {
					String[] cc = sz[b].split(":");
					//System.out.println("cc" + cc[0] + "c1" + cc[1]);
					astring = cc[0];
					bstring = cc[1];
					map.put(bstring, astring);

				}
			}

			for (String key : map.keySet()) {
				String value = map.get(key);
				lists = getKey((HashMap<String, String>) map, value);
				maps.put(value, lists);

			}

			//System.out.println("maps" + maps);
			JSONArray json = JSONArray.fromObject(maps);
			//System.out.println(json);
			str = JsonUtil.getResponseJson(1, "显示成功", null, json);

		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return str;

	}

	@Override
	public int hashCode() {
		return Objects.hash(astring, bstring);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof T_product_specificationController)) {
			return false;
		}
		T_product_specificationController p = (T_product_specificationController) obj;
		if (this.astring.equals(p.astring) && this.bstring.equals(p.bstring)) {
			return true;
		} else {
			return false;
		}

	}

	public static List<String> getKey(HashMap<String, String> map, String v) {

		String key = "";
		List<String> list = new ArrayList<String>();
		for (Entry<String, String> m : map.entrySet()) {

			if (m.getValue().equals(v)) {

				key = m.getKey();

				list.add(key);
			}
		}

		return list;

	}

	/**
	 * 查询价格、库存
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/selectAllspecifications", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String selectAllspecifications(T_product_specification t, String specifications, Long product_id,
			Long attribute, String is_des) {
		if (specifications == null) {
			//System.out.println("specifications不正确");
			return JsonUtil.getResponseJson(-1, "specifications不正确", null, null);

		}
		

		try {

			if (is_des != null) {
				specifications = (Security.decode(specifications));
			} else {

			}
		
			T_product_specification T_product_specification = specificationService.specification(product_id.toString(),
					specifications);
			if (T_product_specification == null) {
				return JsonUtil.getResponseJson(-1, "此类型无货!", null, null);
			}
			Integer number = inventoryService.listInventoryById(T_product_specification.getId(), product_id);
		
			//System.out.println(T_product_specification);
			Integer number1 = inventoryService.listInventoryById(T_product_specification.getId(), product_id);
			

			//System.out.println(number1 + "库存数量");
			if (T_product_specification != null && number != null) {
				return JsonUtil.getResponseJson(1, "查看成功", number, T_product_specification);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

	}

	/**
	 * 
	 *
	 * @Title: selectAllspecificationValueIos
	 * 
	 * @description
	 *
	 * @param @param
	 *            product_id 商品id
	 * @param @return
	 * 
	 * @return String
	 *
	 * 
	 * @author lishaozhang
	 * @createDate 2019年4月24日
	 */
	@RequestMapping(value = "/selectAllspecificationValueIOS", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectAllspecificationValueIOS(Long product_id) {
		try {

			// 根据 商品id查询商品类型
			Long product_type_id = productService.selecProductTypeIdVotById(product_id);

			// g根据商品类型id获取所有该商品的 规格
			List<T_specifications> selectList = specificationsService
					.selectList(new EntityWrapper<T_specifications>().eq("product_type_id", product_type_id));

			// 获取所有商品
			List<T_product_specification> list = specificationMapper
					.selectList(new EntityWrapper<T_product_specification>().eq("product_id", product_id));

			
			ArrayList<IOSProductData> arrayList = new ArrayList<>();
			// 货期所有规格名称 id
			for (T_specifications specificationsVo : selectList) {

				IOSProductData iosProductData = new IOSProductData();

	//			HashMap<String, List<Name>> hashMap = new HashMap<String, List<Name>>();
				ArrayList<Name> nameList = new ArrayList<>();

	//			Long specificationid = specificationsVo.getId();

				// 规格名称
				String specificationsName = specificationsVo.getName();
				
				//判断这个类型是否有相同的规格名称
				Boolean booleanofspecificationsName = true;
				for (IOSProductData isProductData : arrayList) {
					if(specificationsName.equals(isProductData.getSpecificationName())){
						booleanofspecificationsName = false;
					}
					
				}
				//如果没有相同的规格名称则用规格名称获取规格值并存入集合
				if(booleanofspecificationsName){
				
				// 获取规格名称
				iosProductData.setSpecificationName(specificationsName);
				// 获取数据
				for (T_product_specification product_specification : list) {
					// 获取商品里的规格信息
					String specificationName = product_specification.getSpecificationName();
					

					JSONObject parse = (JSONObject) JSONObject.parse(specificationName);
					// 根据规格名称获取规格值
					try {

						// 当没有添加规格时候会抛异常
						Object object = parse.get(specificationsName);

						Name name = new Name();
						String str = object.toString();
						name.setName(str);

						//判断有没有和之前重复的规格
						boolean falg = true;
                      
						for (Name nam : nameList) {
							String namestr = nam.getName();
							if (namestr.equals(str)) {
								//有则标记为false
								falg = false;
							}
						}
                        //没有则加进去
						if (falg) {
							nameList.add(name);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					iosProductData.setList(nameList);
				}

				arrayList.add(iosProductData);
				}
			}

			return JsonUtil.getResponseJson(1, "", null, arrayList);
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "规格信息不规范", null, null);
		}
	}
	/**
	 * 根据商品id查询所有的规格属性以及包含的值
	 * 
	 * @param product_specification
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/selectAllspecifi", produces = "application/json; charset=utf-8")
	@ResponseBody

	public String selectAllspecifi(Long product_id) {
		// String c="{'尺寸'：39cm,'颜色'：红}";
		String str = null;
		try {
			List<StockVo>t2=new ArrayList<StockVo>();
			
			List<T_product_specification> t1=specificationMapper.selectlstspecification(product_id.toString());
			for(int a=0;a<t1.size();a++) {
				StockVo s=new StockVo();
				Integer number = inventoryService.listInventoryById(t1.get(a).getId(), product_id);
				if(number==null) {
					number=0;
				}
				s.setProduct_id(t1.get(a).getProduct_id());
				s.setId(t1.get(a).getId());
				s.setCost_price(t1.get(a).getCost_price());
				s.setDiscount_price(t1.get(a).getDiscount_price());
				s.setPrice(t1.get(a).getPrice());
			s.setNumber(number);
			s.setSpecificationName(t1.get(a).getSpecificationName());
			t2.add(s);
				
			}
			JSONArray json = JSONArray.fromObject(t2);
			//System.out.println(json);
			//System.out.println("t1"+t1);
			str = JsonUtil.getResponseJson(1, "查询成功", null, json);
		} catch (Exception e) {
			str = JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}

		return str;

	}

	/**
	 * 根据id删除商品规格及库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/deleteProductSpecificationById", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteProductSpecificationById(BigInteger id,Long attribute) {
		try {
			int result = specificationService.deleteProductSpecificationById(id);
		int result1 = inventoryService.deleteInventoryByProductSpecificationId(attribute);
			if (result>0) {
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
	 * 修改品规格及库存
	 * 
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/updateProductSpecification", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateProductSpecification(Long product_id,Long attribute,Long id,String specificationName,BigDecimal cost_price,BigDecimal discount_price,BigDecimal price,int number) {
		T_product_specification product_specification = new T_product_specification();
		Inventory inventory = new Inventory();
		product_specification.setId(id);
		product_specification.setSpecificationName(specificationName);
		product_specification.setCost_price(cost_price);
		product_specification.setDiscount_price(discount_price);
		product_specification.setPrice(price);
		inventory.setAttribute(attribute);
		inventory.setNumber(number);
		inventory.setProduct_id(product_id);
		//System.out.println(product_id);
		try {
			int result = specificationService.updateProductSpecification(product_specification);
		    int result1 = inventoryService.updateInventory(inventory);
			if (result>0 || result1>0) {
				return JsonUtil.getResponseJson(1, "修改成功", null, result);
			} else {
				return JsonUtil.getResponseJson(1, "无数据", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
	}
}
