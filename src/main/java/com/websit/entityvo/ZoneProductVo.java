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
     * 商品名称
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
     * 商品价格
     */
    public BigDecimal price;

    /**
     * 颜色
     */
    public String color;
    /**
     * 品牌
     */
    public String brand;

    /**
     * 规格
     */
    public String specifications;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZoneProductVo [id=").append(id).append(", ZoneName=").append(ZoneName).append(", zone_image=")
				.append(zone_image).append(", productaid=").append(productaid).append(", name=").append(name)
				.append(", image=").append(image).append(", price=").append(price).append(", color=").append(color)
				.append(", brand=").append(brand).append(", specifications=").append(specifications).append("]");
		return builder.toString();
	}

	
}
