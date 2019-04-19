package com.websit.mapper;
import java.math.BigInteger;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.websit.entity.SpecificationOptions;
import com.websit.entityvo.SpecificationsVo;

public interface SpecificationOptionsMapper {
	/**
	 * 规格选项列表 分页
	 * @author pangchong
	 * @createDate 2019年4月18日 下午2:00
	 */
	public List<SpecificationOptions> listAllSpecificationOptions(@Param("page") Integer page, @Param("limit") Integer limit);
	/**
	 * @description 查询所有规格选项条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年4月18日
	 */
	Integer findSpecificationsOptionsCount(SpecificationOptions specificationOptions);
	/**
	 * 根据规格id查询规格选项
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	public List<SpecificationOptions> listAllSpecificationOptionsBySpecificationId(Long specificationsId);
	/**
	 * 增加商品规格选项
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int saveSpecificationOptions(SpecificationOptions specificationOptions);
	/**
	 * 修改商品规格选项
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int updateSpecificationOptions(SpecificationOptions specificationOptions);
	/**
	 * description   根据id删除商品规格选项
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteSpecificationOptionsById(@Param("specificationsId") BigInteger specificationsId);
}
