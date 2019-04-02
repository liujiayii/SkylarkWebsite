package com.websit.web;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.websit.entity.T_product_img;
import com.websit.entityvo.ProductVos;
import com.websit.service.IT_product_imgService;
import com.websit.until.JsonUtil;
import com.websit.until.UpdateFile;

@Controller
public class T_product_imgController {
	
	@Autowired
	private IT_product_imgService productImgService;
	/**
	 * 进入上传图片页面
	 * @return
	 */
	@RequestMapping("/importFile")
	public ModelAndView imageFile(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mall/importFile.html");
		return mv;
	}
	/**
	 * 批量上传图片
	 * @param files
	 * @param product_id
	 * @return
	 */
	@RequestMapping("/addImg")
	@ResponseBody
	public String toLoadImg(MultipartFile[] file,Long product_id){
		
		List<String> arrayList = new ArrayList<>();
		for(MultipartFile files : file){
			Map<String,String> update;
			try {
				update = UpdateFile.update(files);
				String imgUrl = update.get("Path");
				//添加图片路径返回前端
				arrayList.add(imgUrl);
				
			} catch (Exception e) {
				e.printStackTrace();
				return JsonUtil.getResponseJson(-1, "系统异常", null, null);
				
			}
		}
		return JsonUtil.getResponseJson(1, "上传成功", null, arrayList);
	}
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteImg")
	@ResponseBody
	public String deleteImg(Long id){
		String res = productImgService.deleteImgById(id);
		return res;
		
	}
	
	/**
	 * 根据商品id查询商品图片
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@RequestMapping(value = "/selectProductImageByProductId", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectProductImageByProductId(BigInteger productId) {
		try{
		List<T_product_img> result = productImgService.selectProductImageByProductId(productId);

		if (result.size()>=1) {
			return JsonUtil.getResponseJson(1, "查看成功", null, result);
		} else {
			return JsonUtil.getResponseJson(1, "无数据", null, null);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(-1, "程序异常", null, null);
	}
	}
}
