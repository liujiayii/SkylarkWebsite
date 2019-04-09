package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.Zone;
import com.websit.entityvo.ZoneProductVo;
import com.websit.entityvo.ZoneVo;
import com.websit.mapper.ZoneMapper;
import com.websit.service.ZoneService;
@Service
public class ZoneServiceImpl implements ZoneService{
	@Autowired
	private ZoneMapper zoneMapper;
	/**
	 * 查询商品专区---不分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public List<Zone> selectZoneNoPage() {
		
		return zoneMapper.selectZoneNoPage();
	}
	/**
	 * 查询商品专区---分页
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public List<Zone> selectZoneList(Integer page, Integer limit) {
	
		return zoneMapper.selectZoneList(page, limit);
	}
	/**
	 * @description 根据专区id查询当前商品专区及每个专区下所有商品
	 * @param zoneId
	 * @return 专区类型及每个专区类型下所有商品
	 * @author pangchong
	 * @createDate 2019年3月21日
	 */
	@Override
	public ZoneVo listZoneByTypeId(BigInteger zoneId) {
	
		return zoneMapper.listZoneByTypeId(zoneId);
	}
	/**
	 * 查询商品专区数量
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public Integer findBpiList(Zone zone) {
		
		return zoneMapper.findBpiList(zone);
	}
	/**
	 * 增加商品专区
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int saveZone(Zone zone) {
		
		return zoneMapper.saveZone(zone);
	}
	/**
	 * 修改商品专区
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int updateZone(Zone zone) {
	
		return zoneMapper.updateZone(zone);
	}
	/**
	 * description   根据id删除商品专区
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	@Override
	public int deleteZoneById(BigInteger id) {
	
		return zoneMapper.deleteZoneById(id);
	}
	@Override
	public List<ZoneProductVo> listZoneByzoneId(BigInteger zoneId) {
		// TODO Auto-generated method stub
		return zoneMapper.listZoneByzoneId(zoneId);
	}

	/**
	 * 根据商品id查询商品专区
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	@Override
	public List<ZoneProductVo> selectZoneByProductId( BigInteger productaid) {
	
		return zoneMapper.selectZoneByProductId(productaid);
	}
	
@Override
public ZoneVo listZoneByTypeIds(BigInteger zoneId,Integer page,Integer limit) {
	// TODO Auto-generated method stub
	return zoneMapper.listZoneByTypeIds(zoneId,page,limit);
}
/**
 * @description 根据专区id查询当前商品专区及每个专区下所有商品(分页)
 * @param zoneId
 * @return 专区类型及每个专区类型下所有商品
 * @author pangchong
 * @createDate 2019年4月8日
 */
@Override
public ZoneVo listZoneByTypeIdPage(BigInteger zoneId, Integer page, Integer limit) {
	
	return zoneMapper.listZoneByTypeIdPage(zoneId, page, limit);
}
/**
 * 按专区id查询商品条数
 * @author pangchong
 * @createDate 2019年3月22日 下午2:00
 */
@Override
public Integer findBpiListByZoneId(BigInteger zoneId) {
	
	return zoneMapper.findBpiListByZoneId(zoneId);
}


}
