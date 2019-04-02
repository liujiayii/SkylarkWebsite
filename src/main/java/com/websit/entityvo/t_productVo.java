package com.websit.entityvo;

import java.math.BigDecimal;
import java.util.Date;

import com.websit.entity.T_product;

public  class t_productVo{
	
	private  String one_name;
	
	

	private  String two_name;


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
     * 颜色
     */
    public String color;

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
     * 规格
     */
    public String specifications;

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
	public String getOne_name() {
		return one_name;
	}
	public void setOne_name(String one_name) {
		this.one_name = one_name;
	}
	public String getTwo_name() {
		return two_name;
	}
	public void setTwo_name(String two_name) {
		this.two_name = two_name;
	}
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
	@Override
	public String toString() {
		return "t_productVo [one_name=" + one_name + ", two_name=" + two_name + ", id=" + id + ", name=" + name
				+ ", product_type_id=" + product_type_id + ", image=" + image + ", price=" + price + ", color=" + color
				+ ", state=" + state + ", create_times=" + create_times + ", brand=" + brand + ", specifications="
				+ specifications + ", describion=" + describion + ", zone_id=" + zone_id + ", zone_name=" + zone_name
				+ "]";
	}

}
