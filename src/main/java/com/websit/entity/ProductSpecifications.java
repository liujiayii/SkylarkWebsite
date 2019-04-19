package com.websit.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSpecifications implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long product_id;
	/**
	 * 商品名称
	 */
	private Long product_name;
	/**
	 * 规格选项id
	 */
	/*private Long specification_options_id;*/
	/**
	 * 规格选项名称
	 */
	private String specificationName;
	/**
	 * 商品成本价
	 */
	private BigDecimal cost_price;
	/**
	 * 商品折扣价
	 */
	private BigDecimal discount_price;
	/**
	 * 商品销售价
	 */
	private BigDecimal price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getProduct_name() {
		return product_name;
	}
	public void setProduct_name(Long product_name) {
		this.product_name = product_name;
	}
	public String getSpecificationName() {
		return specificationName;
	}
	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}
	public BigDecimal getCost_price() {
		return cost_price;
	}
	public void setCost_price(BigDecimal cost_price) {
		this.cost_price = cost_price;
	}
	public BigDecimal getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(BigDecimal discount_price) {
		this.discount_price = discount_price;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductSpecifications [id=").append(id).append(", product_id=").append(product_id)
				.append(", product_name=").append(product_name).append(", specificationName=").append(specificationName)
				.append(", cost_price=").append(cost_price).append(", discount_price=").append(discount_price)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	
}
