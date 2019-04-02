package com.websit.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.websit.entity.T_product_img;
import com.websit.entity.Zone;

/**
 * <p>
 * 商品图片表 Mapper 接口
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public interface T_product_imgMapper extends BaseMapper<T_product_img> {
	
	/**
	 * description   根据商品id删除商品图片
	 *
	 * @author pangchong
	 * @createDate 2019年3月24日 下午2:00
	 */
	public int deleteProductImageByProductId( BigInteger product_id);

	/**
	 * 根据商品id查询商品图片
	 * @author pangchong
	 * @createDate 2019年3月22日 下午2:00
	 */
	List<T_product_img> selectProductImageByProductId(BigInteger product_id);
	
}
