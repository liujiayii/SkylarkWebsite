package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.SpecificationOptions;
import com.websit.mapper.SpecificationOptionsMapper;
import com.websit.service.SpecificationOptionsService;
@Service
public class SpecificationOptionsServiceImpl implements SpecificationOptionsService{
@Autowired
private SpecificationOptionsMapper specificationOptionsMapper;
/**
 * 根据规格id查询规格选项
 * @author pangchong
 * @createDate 2019年3月21日 下午2:00
 */
@Override
public List<SpecificationOptions> listAllSpecificationOptionsBySpecificationId(Long specificationsId) {
	
	return specificationOptionsMapper.listAllSpecificationOptionsBySpecificationId(specificationsId);
}
/**
 * 增加商品规格选项
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int saveSpecificationOptions(SpecificationOptions specificationOptions) {
	
	return specificationOptionsMapper.saveSpecificationOptions(specificationOptions);
}
/**
 * 修改商品规格选项
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int updateSpecificationOptions(SpecificationOptions specificationOptions) {
	
	return specificationOptionsMapper.updateSpecificationOptions(specificationOptions);
}
/**
 * description   根据id删除商品规格选项
 *
 * @author pangchong
 * @createDate 2019年3月23日 下午2:00
 */
@Override
public int deleteSpecificationOptionsById(BigInteger specificationsId) {
	
	return specificationOptionsMapper.deleteSpecificationOptionsById(specificationsId);
}
/**
 * 规格选项列表 分页
 * @author pangchong
 * @createDate 2019年4月18日 下午2:00
 */
@Override
public List<SpecificationOptions> listAllSpecificationOptions(Integer page, Integer limit) {
	
	return specificationOptionsMapper.listAllSpecificationOptions(page, limit);
}
/**
 * @description 查询所有规格选项条数
 * @param 
 * @author pangchong
 * @createDate 2019年4月18日
 */
@Override
public Integer findSpecificationsOptionsCount(SpecificationOptions specificationOptions) {

	return specificationOptionsMapper.findSpecificationsOptionsCount(specificationOptions);
}
}
