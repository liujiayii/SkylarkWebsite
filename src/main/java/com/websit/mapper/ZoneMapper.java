package com.websit.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.Classification;
import com.websit.entity.Zone;
import com.websit.entityvo.ProductTypeVo;
import com.websit.entityvo.ProductVo;
import com.websit.entityvo.ZoneProductVo;
import com.websit.entityvo.ZoneVo;

public interface ZoneMapper {

	/**
	 * 查询商品专区---不分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	List<Zone> selectZoneNoPage();
	/**
	 * 查询商品专区---分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	List<Zone> selectZoneList(@Param("page") Integer page, @Param("limit") Integer limit);
	
	/**
	 * @description 根据专区id查询当前商品专区及每个专区下所有商品
	 * @param zoneId
	 * @return 专区类型及每个专区类型下所有商品
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	public ZoneVo listZoneByTypeId(BigInteger zoneId);
	
	public ZoneVo listZoneByTypeIds(@Param("zoneId")BigInteger zoneId,@Param("page")Integer page,@Param("limit")Integer limit);
	
	public List<ZoneProductVo> listZoneByzoneId(BigInteger zoneId);
	
	/**
	 * 查询商品专区数量
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public Integer findBpiList(Zone zone);
	
	/**
	 * 增加商品专区
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int saveZone(Zone zone);
	/**
	 * 修改商品专区
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int updateZone(Zone zone);
	/**
	 * description   根据id删除商品专区
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int deleteZoneById(@Param("id") BigInteger id);
	/**
	 * 根据商品id查询商品专区
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	List<ZoneProductVo> selectZoneByProductId( BigInteger productaid);
	/**
	 * @description 根据专区id查询当前商品专区及每个专区下所有商品(分页)
	 * @param zoneId
	 * @return 专区类型及每个专区类型下所有商品
	 * @author pangchong
	 * @createDate 2019年4月8日
	 */
	public ZoneVo listZoneByTypeIdPage(@Param("zoneId")BigInteger zoneId,@Param("page") Integer page, @Param("limit") Integer limit);
	/**
	 * 按专区id查询商品条数
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	public Integer findBpiListByZoneId(BigInteger zoneId);
}
