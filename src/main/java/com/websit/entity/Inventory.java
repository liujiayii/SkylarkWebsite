package com.websit.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Inventory extends Model<Inventory> {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 库存id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 商品库存数量
	 */
	private int number;
	/**
	 * 商品id
	 */
	private Long product_id;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 创建时间
	 */
	private Date create_time;
	/**
	 * 商品规格id
	 */
	private Long attribute;
	/**
	 * 商品规格名称
	 */
	private String specificationName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Long getAttribute() {
		return attribute;
	}
	public void setAttribute(Long attribute) {
		this.attribute = attribute;
	}
	public String getSpecificationName() {
		return specificationName;
	}
	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [id=").append(id).append(", number=").append(number).append(", product_id=")
				.append(product_id).append(", productName=").append(productName).append(", create_time=")
				.append(create_time).append(", attribute=").append(attribute).append(", specificationName=")
				.append(specificationName).append("]");
		return builder.toString();
	}
	@Override
	protected Serializable pkVal() {

		return this.id;
	}
	
}
