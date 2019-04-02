package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.websit.entity.T_freight;
import com.websit.service.IT_freightService;
import com.websit.until.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 运费表 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
@Controller
@RequestMapping("/t_freight")
public class T_freightController {
	@Autowired
	public IT_freightService salesService;
	public Integer cood=-1;
	public  String msg="系统异常，请联系客服";
	
	@RequestMapping("/addt_freight")
	@ResponseBody
	public String addt_freight(T_freight t_freight) {
		try {
			
			System.out.println(t_freight.toString());
		if(t_freight.getFreight()==null||t_freight.getPrice()==null||t_freight.getPrices()==null) {
			cood=0003;
			msg="填写的内容不能为空";
		}else {
		
		boolean fig=salesService.insert(t_freight);
		if(fig) {
			cood=0001;
			msg="添加成功";
		}else {
			cood=0002;
			msg="添加失败";
		}
		}
		} finally {
			return JsonUtil.getResponseJson(cood,msg, null, null);
		} 
		
	}
	
	@RequestMapping("/delt_freight")
	@ResponseBody
	public String delt_freight(long id) {
		
			
		
		boolean fig=salesService.deleteById(id);
		if(fig) {
			cood=0001;
			msg="删除成功";
		}else {
			cood=0002;
			msg="删除失败";
		}
		
		
			return JsonUtil.getResponseJson(cood,msg, null, null);
		
	}

	@SuppressWarnings("finally")
	@RequestMapping("/selt_freight")
	@ResponseBody
	public String selt_freight(T_freight t_freight) {
		List<T_freight> freight=null;
		try {
			Map<String, Object> columnMap=new HashMap<String,Object>();
			
		   if(t_freight.getPrice()!=null) {
			columnMap.put("price",t_freight.getPrice());
		   }else if (t_freight.getPrices()!=null){
		
		
			columnMap.put("prices",t_freight.getPrices());
		   }
		
		   else if(t_freight.getFreight()!=null){
			columnMap.put("freight",t_freight.getFreight());
			
		   }
		
		//System.out.println(columnMap+"666666666666666666666666666666666666666666666666666666"+t_freight+t_freight.getPrice());
			
		       freight=salesService.selectByMap(columnMap);
		if(freight.size()>0) {
			cood=1;
			msg="查询成功";
		}else {
			cood=1;
			msg="查询成功";
		}
		System.err.println(freight+"+++++++++++++++++++++++++++++++++++++++++++++++");
		} finally {
			return JsonUtil.getResponseJson(cood,msg, null, freight);
		} 
	}
	

}
