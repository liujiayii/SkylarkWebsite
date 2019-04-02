package com.websit.entityvo;

import java.math.BigDecimal;
import java.util.Date;

import com.websit.entity.T_shopping;

public class shopinglist  extends T_shopping {
	 /**
     * 商品名称
     */
    private String name;
    /**
     * 图片
     */
    private String image;
    /**
     * 主键id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品类型id
     */
    private Long producttypeid;
    /**
     * 商品类型名称
     */
    private String producttypename;
    /**


    /**
     * 商品价格
     */
    private BigDecimal price;

    @Override
	public String toString() {
		return "shopinglist [name=" + name + ", image=" + image + ", productId=" + productId + ", productName="
				+ productName + ", producttypeid=" + producttypeid + ", producttypename=" + producttypename + ", price="
				+ price + ", color=" + color + ", state=" + state + ", create_times=" + create_times + ", brand="
				+ brand + ", specifications=" + specifications + ", describion=" + describion + ", classificationIds="
				+ classificationIds + ", classificationNames=" + classificationNames + ", zoneIds=" + zoneIds
				+ ", zoneNames=" + zoneNames + "]";
	}
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
	public Long getProducttypeid() {
		return producttypeid;
	}
	public void setProducttypeid(Long producttypeid) {
		this.producttypeid = producttypeid;
	}
	public String getProducttypename() {
		return producttypename;
	}
	public void setProducttypename(String producttypename) {
		this.producttypename = producttypename;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreate_times() {
		return create_times;
	}
	public void setCreate_times(Date create_times) {
		this.create_times = create_times;
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
	public String getDescribion() {
		return describion;
	}
	public void setDescribion(String describion) {
		this.describion = describion;
	}
	public Long getClassificationIds() {
		return classificationIds;
	}
	public void setClassificationIds(Long classificationIds) {
		this.classificationIds = classificationIds;
	}
	public String getClassificationNames() {
		return classificationNames;
	}
	public void setClassificationNames(String classificationNames) {
		this.classificationNames = classificationNames;
	}
	public Long getZoneIds() {
		return zoneIds;
	}
	public void setZoneIds(Long zoneIds) {
		this.zoneIds = zoneIds;
	}
	public String getZoneNames() {
		return zoneNames;
	}
	public void setZoneNames(String zoneNames) {
		this.zoneNames = zoneNames;
	}
	/**
     * 颜色
     */
    private String color;

    /**
     * 状态(1:上架,2:下架)
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date create_times;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 商品描述
     */
    private String describion;
    /**
     * 商品一级分类id
     */
    private Long classificationIds;
    /**
     * 商品一级分类名称
     */
    private String classificationNames;
    /**
     * 商品一级分类id
     */
    private Long zoneIds;
    /**
     * 商品一级分类名称
     */
    private String zoneNames;
    
    
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
    
}
