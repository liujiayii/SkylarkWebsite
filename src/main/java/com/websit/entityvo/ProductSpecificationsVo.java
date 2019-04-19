package com.websit.entityvo;

import java.io.Serializable;
import java.util.List;

import com.websit.entity.ProductSpecifications;

/**
 *
 * @ClassName: ProductSpecificationsVo

 * @description 
 *
 * @author 
 * @createDate 2019年4月16日
 */

public class ProductSpecificationsVo implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * 商品名称
	 */
	private Long productName;
	
	/**
	 * 商品所包含的该商品规格集合
	 */
	private List<ProductSpecifications> productSpecifications;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductName() {
		return productName;
	}

	public void setProductName(Long productName) {
		this.productName = productName;
	}

	public List<ProductSpecifications> getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(List<ProductSpecifications> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductSpecificationsVo [productId=").append(productId).append(", productName=")
				.append(productName).append(", productSpecifications=").append(productSpecifications).append("]");
		return builder.toString();
	}
	
}
