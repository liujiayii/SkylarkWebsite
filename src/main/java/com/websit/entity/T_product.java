package com.websit.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_product implements Serializable {

    public static final long serialVersionUID = 1L;

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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public T_product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T_product [id=").append(id).append(", name=").append(name).append(", product_type_id=")
				.append(product_type_id).append(", image=").append(image).append(", price=").append(price)
				.append(", color=").append(color).append(", state=").append(state).append(", create_times=")
				.append(create_times).append(", brand=").append(brand).append(", specifications=")
				.append(specifications).append(", describion=").append(describion).append(", zone_id=").append(zone_id)
				.append(", zone_name=").append(zone_name).append("]");
		return builder.toString();
	}
	
}
