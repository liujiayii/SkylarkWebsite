package com.websit.service.impl;

import com.websit.constant.ExpressEnum;
import com.websit.constant.ExpressReturnCodeEnum;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_express;
import com.websit.entity.T_express_details;
import com.websit.entityvo.ExpressDetailsVo;
import com.websit.mapper.T_expressMapper;
import com.websit.service.IT_expressService;
import com.websit.until.ExpressUtil;
import com.websit.until.JsonUtil;
import com.websit.until.RedisUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 快递公司表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
@Service
public class T_expressServiceImpl extends ServiceImpl<T_expressMapper, T_express> implements IT_expressService {

	@Autowired
	private T_expressMapper t_expressMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 通过快递单号查询快递信息
	 * map.put("number","快递单号")
	 */
	@Override
	public String selectExpressDetails(Map<String, String> map) {
		JSONObject expressInfo = null;
		// 先从redis中查询，如果有信息则返回
		if (redisUtil.hasKey(map.get("number"))) {
			return  JSONObject.toJSONString(redisUtil.get(map.get("number")));
		}
		// 先从数据库中查询，如果有信息则返回，没有信息则调用第三方查询快递接口
		ExpressDetailsVo expressDetailsVo = t_expressMapper.selectExpressDetails(map);
		
		if (expressDetailsVo != null) {
			return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, expressDetailsVo.getId().intValue(), expressDetailsVo);
		} else {
			map.put("no", map.get("number"));
		}
		
		// 获取查询订单返回的数据
		expressInfo = JSONObject.parseObject(ExpressUtil.fegine(map));
		
		/** 将查到的结果存到redis中，有效时间2个小时 */
		redisUtil.set(map.get("number"), expressInfo, 7200);
		
		/** 如果快递已签收 */
		try {
			this.insert(expressInfo, map);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return expressInfo.toJSONString();
	} 
	
	/**
	 * 添加快递表和快递详情表
	 *
	 * @Title: insert
	 * @description 
	 * @param expressInfo 查询快递返回json串
	 * @param map 快递单号在map中作为查询条件
	 * @return  
	 * void    
	 * @author lujinpeng
	 * @createDate 2019年3月22日-上午11:13:08
	 */
	public void insert(JSONObject expressInfo, Map<String, String> map) {
		
		JSONObject resultJson = expressInfo.getJSONObject("result");
		
		/** 如果快递已签收、退签、派送失败、疑难件 则将数据添加到数据库中 */
		if ( resultJson.getIntValue("deliverystatus") == ExpressEnum.SIGN_FOR.getIndex()
				|| resultJson.getIntValue("deliverystatus") == ExpressEnum.BACK_TO_SIGN.getIndex()
				|| resultJson.getIntValue("deliverystatus") == ExpressEnum.SEND_FAILED.getIndex()
				|| resultJson.getIntValue("deliverystatus") == ExpressEnum.DIFFICULT.getIndex()) {
			
			JSONArray listArr = resultJson.getJSONArray("list");
			
			for (Object obj : listArr) {
	  	        T_express_details t_express_details = JSON.parseObject(JSONObject.toJSONString(obj), T_express_details.class);
	  	        t_express_details.setNumber(map.get("number"));
	  	        // 添加到快递详情表
	  	        t_express_details.insert();
		    }
			
			resultJson.remove("list");
			T_express express = JSON.parseObject(JSONObject.toJSONString(resultJson), T_express.class);
			express.setNumber(map.get("number"));
			// 添加到快递表
			express.insert();
			
		}
		
	}
	
	
	

}
