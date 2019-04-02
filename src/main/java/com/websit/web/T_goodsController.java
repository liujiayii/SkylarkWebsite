package com.websit.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.websit.entity.T_goods;
import com.websit.service.IT_goodsService;
import com.websit.until.JsonUtil;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 收货地址 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
@Controller
@RequestMapping("/t_goods")
public class T_goodsController {

	@Autowired
	private IT_goodsService goodsService;
	
	/**
	 * 添加地址
	 * @param t
	 * @return
	 */
	@RequestMapping("/addGoods")
	@ResponseBody
	public synchronized String addGoods(@RequestBody T_goods t){
		
		String atr;
		try {
			String s=t.getGoods_ster();
			if(s.equals("1")){
				T_goods t_goods = new T_goods();
				t_goods.setGoods_ster("2");
				@SuppressWarnings("unused")
				boolean update = goodsService.update(t_goods, 
						new EntityWrapper<T_goods>().eq("user_id", t.getUser_id()).eq("goods_ster", "1"));
			}
			boolean a=goodsService.insert(t);
			if(a==true){
				atr=JsonUtil.getResponseJson(1, "添加成功", null, null);
			}else{
				atr=JsonUtil.getResponseJson(2, "添加失败", null, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			atr= JsonUtil.getResponseJson(-1, "程序异常", null, null);
		}
		return atr;
	}
	
	/**
	 * 添加地址（APP端）
	 * @param t
	 * @return
	 */
	@RequestMapping("/addGoodsScend")
	@ResponseBody
	public synchronized String addGoodsScend( T_goods t){
		
		String atr;
		try {
			String s=t.getGoods_ster();
			if(s.equals("1")){
				T_goods t_goods = new T_goods();
				t_goods.setGoods_ster("2");
				@SuppressWarnings("unused")
				boolean update = goodsService.update(t_goods, 
						new EntityWrapper<T_goods>().eq("user_id", t.getUser_id()).eq("goods_ster", "1"));
			}
			boolean a=goodsService.insert(t);
			if(a==true){
				atr=JsonUtil.getResponseJson(1, "添加成功", null, null);
			}else{
				atr=JsonUtil.getResponseJson(2, "添加失败", null, null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			atr= JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return atr;
	}
	/**
	 * 查询地址 用户id
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectGoods")
	@ResponseBody
	public String selectGoods(BigInteger id){
		
		String str;
		try {
			List<T_goods >list=goodsService.selectList(new EntityWrapper<T_goods>().eq("user_id", id));
			if(list.size()==0){
				str=JsonUtil.getResponseJson(2, "暂无地址", null, null);
			}else{
				str=JsonUtil.getResponseJson(1, "查询成功", null, list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
			
		}
		
		return str;
	}
	/**
	 * 通过id查询数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectFindIds")
	@ResponseBody
	public String selectFindIds(String goods_id){
		
		String str;
		try {
			T_goods goods=goodsService.selectById(goods_id);
			if(goods==null){
				str=JsonUtil.getResponseJson(2, "暂无地址", null, null);
			}else{
				str=JsonUtil.getResponseJson(1, "查询成功", null, goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
			
		}
		
		return str;
	}
	/**
	 * 删除地址
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/deletGoods")
	@ResponseBody
	public String deletGoods(Integer goods_id){
		
		String str;
		try {
			boolean a=goodsService.deleteById(goods_id);
			if(a==true){
				str=JsonUtil.getResponseJson(1, "删除成功", null, null);
			}else{
				str=JsonUtil.getResponseJson(-1, "删除失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
			
		}
		
		return str;
	} 
	/**
	 * 修改地址 (Pc端使用)
	 * @param t
	 * @return
	 */
	@RequestMapping("/updateGoods")
	@ResponseBody
	public String updateGoods(@RequestBody T_goods t){
		
		String str;
		try {
			String s=t.getGoods_ster();
			if(s.equals("1")){
				T_goods t_goods = new T_goods();
				t_goods.setGoods_ster("2");
				@SuppressWarnings("unused")
				boolean update = goodsService.update(t_goods, 
						new EntityWrapper<T_goods>().eq("user_id", t.getUser_id()).eq("goods_ster", "1"));
			}
			boolean a=goodsService.updateById(t);
			if(a==true){
				str=JsonUtil.getResponseJson(1, "修改成功", null, null);
			}else{
				str=JsonUtil.getResponseJson(2, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	
	/**
	 * 修改地址 (APP端使用)
	 * @param t
	 * @return
	 */
	@RequestMapping("/updateGoodsScend")
	@ResponseBody
	public String updateGoodsScend( T_goods t){
		
		String str;
		try {
			String s=t.getGoods_ster();
			if(s.equals("1")){
				T_goods t_goods = new T_goods();
				t_goods.setGoods_ster("2");
				@SuppressWarnings("unused")
				boolean update = goodsService.update(t_goods, 
						new EntityWrapper<T_goods>().eq("user_id", t.getUser_id()).eq("goods_ster", "1"));
			}
			boolean a=goodsService.updateById(t);
			if(a==true){
				str=JsonUtil.getResponseJson(1, "修改成功", null, null);
			}else{
				str=JsonUtil.getResponseJson(2, "修改失败", null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str=JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return str;
	}
	
}
