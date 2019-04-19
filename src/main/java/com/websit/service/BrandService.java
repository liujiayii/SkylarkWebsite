package com.websit.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.Brand;

public interface BrandService {
	/**
	 * 品牌列表---不分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	public List<Brand> listAllBrandNoPage();
	/**
	 * 品牌列表---分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	public List<Brand> listAllBrand(@Param("page") Integer page, @Param("limit") Integer limit);
	/**
	 * @description 查询所有品牌条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	Integer findBrandCount(Brand brand);
	/**
	 * 增加商品品牌
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int saveBrand(Brand brand);
	/**
	 * 修改商品品牌
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int updateBrand(Brand brand);
	/**
	 * description   根据id删除商品品牌
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	public int deleteBrandById(@Param("id") BigInteger id);
}
