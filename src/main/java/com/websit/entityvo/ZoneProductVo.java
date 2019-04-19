package com.websit.entityvo;

import java.math.BigDecimal;

public class ZoneProductVo {
	 /**
     * 主键id
     */
    public Long id;
	/**
     * 专区名称
     */
    private String ZoneName;
    /**
     * 专区图片
     */
    private String zone_image;
    /**
     * 商品id
     */
    public Long productaid;
    /**
     * 商品名称
     */
    public String name;
    /**
     * 图片
     */
    public String image;

    /**
     * 商品销售价格
     */
    public BigDecimal price;

    /**
     * 商品成本价
     */
    public BigDecimal cost_price;
    /**
     * 商品折扣价
     */
    public BigDecimal discount_price;
    /**
     * 品牌
     */
    public String brand;

    /**
     * 售后信息
     */
    private String after_information;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZoneName() {
		return ZoneName;
	}

	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}

	public String getZone_image() {
		return zone_image;
	}

	public void setZone_image(String zone_image) {
		this.zone_image = zone_image;
	}

	public Long getProductaid() {
		return productaid;
	}

	public void setProductaid(Long productaid) {
		this.productaid = productaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAfter_information() {
		return after_information;
	}

	public void setAfter_information(String after_information) {
		this.after_information = after_information;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZoneProductVo [id=").append(id).append(", ZoneName=").append(ZoneName).append(", zone_image=")
				.append(zone_image).append(", productaid=").append(productaid).append(", name=").append(name)
				.append(", image=").append(image).append(", price=").append(price).append(", cost_price=")
				.append(cost_price).append(", discount_price=").append(discount_price).append(", brand=").append(brand)
				.append(", after_information=").append(after_information).append("]");
		return builder.toString();
	}

	
	
}
