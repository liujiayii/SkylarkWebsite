package com.websit.entityvo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Discount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long discountid;
	private Long productid;
	private String productname;
	private BigDecimal price;
	private BigDecimal money;
	public Long getDiscountid() {
		return discountid;
	}
	public void setDiscountid(Long discountid) {
		this.discountid = discountid;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Discount [discountid=").append(discountid).append(", productid=").append(productid)
				.append(", productname=").append(productname).append(", price=").append(price).append(", money=")
				.append(money).append("]");
		return builder.toString();
	}
	
	
}
