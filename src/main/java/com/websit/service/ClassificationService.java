package com.websit.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.Classification;
import com.websit.entityvo.ProductVos;

public interface ClassificationService {

	/**
	 * @description 根据一级类型id查询当前一级类型及每个一级类型下所有商品类型(app)
	 * @param classificationId
	 * @author pangchong
	 * @createDate 2019年3月23日
	 */
	public String listClassificationByClassificationId(Long classificationId);
	
	/**
	 * @description 查询一级分类(app)
	 * @author pangchong
	 * @createDate 2019年3月23日
	 */
	public List<ProductVos> listClassificationList();
	/**
	 * @description 查询商品一级分类--- 分页
	 * @param 
	 * @author pangchong
	 * @param name 
	 * @createDate 2019年3月23日
	 */
	public List<Classification> listAllClassification(@Param("page") Integer page, @Param("limit") Integer limit, @Param("name")String name);

	/**
	 * 增加商品一级分类
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int saveClassification(Classification classification);
	/**
	 * 修改商品一级分类
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int updateClassification(Classification classification);
	/**
	 * 查询商品一级分类条数
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public Integer findClassificationCount(Classification classification);
	
	/**
	 * description   根据id删除商品一级分类
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteClassificationById(@Param("id") BigInteger id);
	
	public List<Classification> selectClassification();

}
