package com.websit.entityvo;

import java.io.Serializable;
import java.util.List;

import com.websit.entity.T_discount;

public class DiscountVo implements Serializable{

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
	private String productName;
	/**
	 * 商品所包含的满减金额
	 */
	private List<T_discount> discountList;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<T_discount> getDiscountList() {
		return discountList;
	}
	public void setDiscountList(List<T_discount> discountList) {
		this.discountList = discountList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public DiscountVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiscountVo [productId=").append(productId).append(", productName=").append(productName)
				.append(", discountList=").append(discountList).append("]");
		return builder.toString();
	}
	

}
