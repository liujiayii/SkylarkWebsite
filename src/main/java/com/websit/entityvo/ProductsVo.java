package com.websit.entityvo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductsVo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键id
     */
    public Long id;

    /**
     * 商品名称
     */
    public String name;

    /**
     * 商品类型id
     */
    public Long product_type_id;

    /**
     * 图片
     */
    public String image;
    /**
     * 商品价格
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
     * 状态(1:上架,2:下架)
     */
    public Integer state;

    /**
     * 创建时间
     */
    public Date create_times;

    /**
     * 品牌
     */
    public String brand;

    /**
     * 商品描述
     */
    public String describion;
    /**
     * 专区id
     */
    public Long zone_id;
    /**
     * 专区名称
     */
    public Long zone_name;
    /**
     * 售后信息
     */
    private String after_information;
    /**
     * 商品一级分类id
     */
    private Long classificationIds;
    /**
     * 商品一级分类名称
     */
    private String classificationNames;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getProduct_type_id() {
		return product_type_id;
	}
	public void setProduct_type_id(Long product_type_id) {
		this.product_type_id = product_type_id;
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
	public String getDescribion() {
		return describion;
	}
	public void setDescribion(String describion) {
		this.describion = describion;
	}
	public Long getZone_id() {
		return zone_id;
	}
	public void setZone_id(Long zone_id) {
		this.zone_id = zone_id;
	}
	public Long getZone_name() {
		return zone_name;
	}
	public void setZone_name(Long zone_name) {
		this.zone_name = zone_name;
	}
	public String getAfter_information() {
		return after_information;
	}
	public void setAfter_information(String after_information) {
		this.after_information = after_information;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductsVo [id=").append(id).append(", name=").append(name).append(", product_type_id=")
				.append(product_type_id).append(", image=").append(image).append(", price=").append(price)
				.append(", cost_price=").append(cost_price).append(", discount_price=").append(discount_price)
				.append(", state=").append(state).append(", create_times=").append(create_times).append(", brand=")
				.append(brand).append(", describion=").append(describion).append(", zone_id=").append(zone_id)
				.append(", zone_name=").append(zone_name).append(", after_information=").append(after_information)
				.append(", classificationIds=").append(classificationIds).append(", classificationNames=")
				.append(classificationNames).append("]");
		return builder.toString();
	}
	
}
