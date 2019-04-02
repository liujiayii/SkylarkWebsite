package com.websit.entityvo;

import java.io.Serializable;

public class ProductImage implements Serializable{

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
	private String product_name;
	/**
	 * 商品详情图片
	 */
	private String img;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductImage [id=").append(id).append(", product_id=").append(product_id)
				.append(", product_name=").append(product_name).append(", img=").append(img).append("]");
		return builder.toString();
	}
	
}
