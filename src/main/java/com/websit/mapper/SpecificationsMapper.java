package com.websit.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entityvo.SpecificationsVo;

public interface SpecificationsMapper {
	/**
	 * @description 根据商品id查询当前规格及每个规格下所有规格选项
	 * @param specificationsId
	 * @return 规格及每个规格下所有规格选项
	 * @author pangchong
	 * @createDate 2019年4月10日
	 */
	public List<SpecificationsVo> listSpecificationsBySpecificationsId(@Param("product") Long product);
	/**
	 * @description 根据商品类型id查询规格
	 * @param producttypeid
	 * @return 规格
	 * @author pangchong
	 * @createDate 2019年4月11日
	 */
	public List<SpecificationsVo> listSpecificationsByproducttypeid(@Param("producttypeid") Long producttypeid);
	/**
	 * 规格列表---分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	public List<SpecificationsVo> listAllSpecifications(@Param("page") Integer page, @Param("limit") Integer limit);
	/**
	 * @description 查询所有规格条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	Integer findSpecificationsVoCount(SpecificationsVo specificationsVo);
	/**
	 * 增加商品规格
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int saveSpecificationsVo(SpecificationsVo specificationsVo);
	/**
	 * 修改商品规格
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int updateSpecificationsVo(SpecificationsVo specificationsVo);
	/**
	 * description   根据id删除商品规格
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteSpecificationsVoById(@Param("specificationsId") BigInteger specificationsId);
}
