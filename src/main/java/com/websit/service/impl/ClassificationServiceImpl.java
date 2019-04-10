package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.constant.ReturnCode;
import com.websit.entity.Classification;
import com.websit.entityvo.PostingPlateVo;
import com.websit.entityvo.ProductVos;
import com.websit.mapper.ClassificationMapper;
import com.websit.service.ClassificationService;
import com.websit.until.JsonUtil;

@Service
public class ClassificationServiceImpl implements ClassificationService{
@Autowired
private ClassificationMapper classificationMapper;
/**
 * @description 查询一级分类
 * @author pangchong
 * @createDate 2019年3月23日
 */
@Override
public List<ProductVos> listClassificationList() {
	
	return classificationMapper.listClassificationList();
}
/**
 * @description 根据一级类型id查询当前一级类型及每个一级类型下所有商品类型(app)
 * @param classificationId
 * @author pangchong
 * @createDate 2019年3月23日
 */
@Override
public String listClassificationByClassificationId(Long classificationId) {
	ProductVos result = null;
	try {
		 result = classificationMapper.listClassificationByClassificationId(classificationId);
		
		if (result == null) {
			return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, null, new ProductVos());
		}
	} catch (Exception e) {
		e.printStackTrace();
		return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
	}
	
	return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, null, result);
}
/**
 * @description 查询商品一级分类--- 分页
 * @param 
 * @author pangchong
 * @createDate 2019年3月23日
 */
@Override
public List<Classification> listAllClassification(Integer page, Integer limit,String name) {
	
	return classificationMapper.listAllClassification(page, limit,name);
}
/**
 * 增加商品一级分类
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int saveClassification(Classification classification) {
	
	return classificationMapper.saveClassification(classification);
}
/**
 * 修改商品一级分类
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int updateClassification(Classification classification) {

	return classificationMapper.updateClassification(classification);
}
/**
 * 查询商品一级分类条数
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public Integer findClassificationCount(Classification classification) {
	
	return classificationMapper.findClassificationCount(classification);
}
/**
 * description   根据id删除商品一级分类
 *
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int deleteClassificationById(BigInteger id) {
	
	return classificationMapper.deleteClassificationById(id);
}
@Override
public List<Classification> selectClassification() {
	
	return classificationMapper.selectClassification();
}








}
