package com.websit.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.websit.entity.T_app;
import com.websit.entity.T_user;
import com.websit.service.IT_appService;
import com.websit.until.JsonUtil;
import com.websit.until.UpdateFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app版本控制 前端控制器
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-15
 */
@Controller
@RequestMapping("/t_app")

public class T_appController {
	@Autowired
	public IT_appService appService;
	@RequestMapping(value = "/inserttapp", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addt_app(T_app app,HttpServletRequest req)  {
		try {
			
	
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("app_name", app.getApp_name());
		map3.put("app_type", app.getApp_type());
		List<T_app> records =appService.selectByMap(map3);
		boolean fig = false;
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest)req;
		List<MultipartFile> files = multipartRequest.getFiles("pic");
	    if(files.size()==0) {
	    	if(records.size()==0) {
	    	 app.setApp_cood("1");
	    	 fig=appService.insert(app);
	    	}else {
	        	if(app.getApp_type().equals("1")) {
	        		app.setApp_url(records.get(0).getApp_url());
	        	}
	        	fig=appService.uodatevison(app);
	        }
	    }else {
		//System.out.println(multipartRequest.getFiles("pic"));
		for (MultipartFile multipartFile : files) {
			Map<String, String> map = UpdateFile.update(multipartFile);
			String urls = map.get("Path");
	        System.out.println(urls);
	       
	        app.setApp_url(urls);
	        if(records.size()==0) {
	        	app.setApp_cood("1");
	        fig=appService.insert(app);
	        }else {
	        	if(app.getApp_type().equals("1")) {
	        		app.setApp_url(records.get(0).getApp_url());
	        	}
	        	fig=appService.uodatevison(app);
	        }
		}
	    }
		if(fig) {
		
		return JsonUtil.getResponseJson(1, "添加版本成功", null, null);
		
		}
		return JsonUtil.getResponseJson(-1, "修改版本失败", null, null);
		
		} catch (Exception e) {
			return JsonUtil.getResponseJson(-1, "修改版本失败", null, null);
		}
	}
	@RequestMapping(value = "/insertlist", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addlist()  {
	
		List<T_app> ser =appService.selectByMap(null);
		return JsonUtil.getResponseJson(1, "添加版本成功", ser.size(), ser);
		
	
		
	}
	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String update(T_app app)  {
	     
		
		return JsonUtil.getResponseJson(1, "添加版本成功", null, null);
		
	
		
	}
	
	@RequestMapping(value = "/Updatapp")
	@ResponseBody
	public String Updatapp(T_app app)  {
	     try {
			
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("app_name", app.getApp_name());
		map3.put("app_type", app.getApp_type());
		
		List<T_app> records =appService.selectByMap(map3);
		if(Integer.valueOf(records.get(0).getApp_cood())>Integer.valueOf(app.getApp_cood())&&app.getApp_type().equals("0")) {
			return JsonUtil.getResponseJson(1, "需要更新", null, records.get(0).getApp_url());
		}else if(Integer.valueOf(records.get(0).getApp_cood())>Integer.valueOf(app.getApp_cood())&&app.getApp_type().equals("1")){
			return JsonUtil.getResponseJson(1, "需要更新", null, records);
		}
		return JsonUtil.getResponseJson(-1, "已经是最新版本", null, null);
	     } catch (Exception e) {
	    	 return JsonUtil.getResponseJson(-1, "已经是最新版本", null, null);
			}
		}
	@RequestMapping(value = "/seletapp")
	@ResponseBody
	public String seletapp(T_app app)  {
	     
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("app_name", app.getApp_name());
		map3.put("app_type", app.getApp_type());
		
		List<T_app> records =appService.selectByMap(map3);
	
	    if(records.size()>0) {
		return JsonUtil.getResponseJson(1, "需要更新", null, records.get(0).getApp_url());
	    }
	    return JsonUtil.getResponseJson(1, "需要更新", null, "正在处理中");
		}
	
		
	}
	
	
	
	
	

