package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entityvo.SpecificationsVo;
import com.websit.mapper.SpecificationsMapper;
import com.websit.service.SpecificationsService;
@Service
public class SpecificationsServiceImpl implements SpecificationsService{
	@Autowired
	
	private SpecificationsMapper specificationsMapper;
	/**
	 * @description 根据规格id查询当前规格及每个规格下所有规格选项
	 * @param specificationsId
	 * @return 规格及每个规格下所有规格选项
	 * @author pangchong
	 * @createDate 2019年4月10日
	 */
	@Override
	public List<SpecificationsVo> listSpecificationsBySpecificationsId(Long specificationsId) {
		
		return specificationsMapper.listSpecificationsBySpecificationsId(specificationsId);
	}
	/**
	 * @description 根据商品类型id查询规格
	 * @param producttypeid
	 * @return 规格
	 * @author pangchong
	 * @createDate 2019年4月11日
	 */
	@Override
	public List<SpecificationsVo> listSpecificationsByproducttypeid(Long producttypeid) {
		
		return specificationsMapper.listSpecificationsByproducttypeid(producttypeid);
	}
	
	/**
	 * 规格列表---分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@Override
	public List<SpecificationsVo> listAllSpecifications(Integer page, Integer limit) {
		
		return specificationsMapper.listAllSpecifications(page, limit);
	}
	/**
	 * @description 查询所有规格条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	@Override
	public Integer findSpecificationsVoCount(SpecificationsVo specificationsVo) {
		
		return specificationsMapper.findSpecificationsVoCount(specificationsVo);
	}
	/**
	 * 增加商品规格
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int saveSpecificationsVo(SpecificationsVo specificationsVo) {
	
		return specificationsMapper.saveSpecificationsVo(specificationsVo);
	}
	/**
	 * 修改商品规格
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int updateSpecificationsVo(SpecificationsVo specificationsVo) {
		
		return specificationsMapper.updateSpecificationsVo(specificationsVo);
	}
	/**
	 * description   根据id删除商品规格
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int deleteSpecificationsVoById(Long specificationsId) {
		
		return specificationsMapper.deleteSpecificationsVoById(specificationsId);
	}
	
}
