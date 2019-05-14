package com.websit.service.impl;



import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.entity.T_product_img;
import com.websit.mapper.T_product_imgMapper;
import com.websit.service.IT_product_imgService;
import com.websit.until.JsonUtil;
import com.websit.until.UpdateFile;

/**
 * <p>
 * 商品图片表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_product_imgServiceImpl extends ServiceImpl<T_product_imgMapper, T_product_img> implements IT_product_imgService {
	
	@Autowired
	private T_product_imgMapper productImgMapper;


	@Override
	public String deleteImgById(Long id) {
//		T_product_img productImg = productImgMapper.selectById(id);
//		String url = productImg.getImg();
//		Map<String,Object> map = null;
//		try {
//			boolean is = UpdateFile.deleatFile(url);
//			if(is){
//				
//				
//			}
//			productImgMapper.deleteById(id);
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		return map.toString();
		String res;
		T_product_img productImg = productImgMapper.selectById(id);
		String url = productImg.getImg();
		try {
			boolean isDelete = UpdateFile.deleatFile(url);
			if(isDelete){
				
				productImgMapper.deleteById(id);
				res =JsonUtil.getResponseJson(1, "删除成功", null, null);
			}else{
				productImgMapper.deleteById(id);
				res =JsonUtil.getResponseJson(1, "删除成功", null, null);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			res =JsonUtil.getResponseJson(-1, "系统异常", null, null);
		}
		return res;
	}

	/**
	 * description   根据商品id删除商品图片
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */

	@Override
	public int deleteProductImageByProductId(BigInteger product_id) {
		
		return productImgMapper.deleteProductImageByProductId(product_id);
	}
	/**
	 * 根据商品id查询商品图片
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	
	@Override
	public List<T_product_img> selectProductImageByProductId(BigInteger product_id) {
	
		return productImgMapper.selectProductImageByProductId(product_id);
	}
	
}
