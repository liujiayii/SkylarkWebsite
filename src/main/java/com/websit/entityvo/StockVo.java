package com.websit.entityvo;

import java.math.BigDecimal;

public class StockVo {
	private Long id;
	
	private Long product_id;

	  /**
     * 商品规格选项表数组
     */
    private String specificationName;

    /**
     * 成本价
     */
    private BigDecimal cost_price;

    /**
     * 折扣价
     */
    private BigDecimal discount_price;

    /**
     * 销售价
     */
    private BigDecimal price;
    
    private Integer number;

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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	

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

	@Override
	public String toString() {
		return "StockVo [id=" + id + ", product_id=" + product_id + ", specificationName=" + specificationName
				+ ", cost_price=" + cost_price + ", discount_price=" + discount_price + ", price=" + price + ", number="
				+ number + "]";
	}

	
    
	

}
