package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.Brand;
import com.websit.mapper.BrandMapper;
import com.websit.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandMapper brandMapper;
	/**
	 * 品牌列表---不分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@Override
	public List<Brand> listAllBrandNoPage() {
	
		return brandMapper.listAllBrandNoPage();
	}
	/**
	 * 品牌列表---分页
	 * @author pangchong
	 * @createDate 2019年3月21日 下午2:00
	 */
	@Override
	public List<Brand> listAllBrand(Integer page, Integer limit) {
	
		return brandMapper.listAllBrand(page, limit);
	}
	/**
	 * @description 查询所有品牌条数
	 * @param 
	 * @author pangchong
	 * @createDate 2019年3月25日
	 */
	@Override
	public Integer findBrandCount(Brand brand) {
		
		return brandMapper.findBrandCount(brand);
	}
	/**
	 * 增加商品品牌
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int saveBrand(Brand brand) {
		
		return brandMapper.saveBrand(brand);
	}
	/**
	 * 修改商品品牌
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int updateBrand(Brand brand) {
		
		return brandMapper.updateBrand(brand);
	}
	/**
	 * description   根据id删除商品品牌
	 *
	 * @author pangchong
	 * @createDate 2019年3月23日 下午2:00
	 */
	@Override
	public int deleteBrandById(BigInteger id) {
	
		return brandMapper.deleteBrandById(id);
	}
	


	
	

}
