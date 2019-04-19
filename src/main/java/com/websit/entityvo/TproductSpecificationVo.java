package com.websit.entityvo;

import java.util.Date;

import com.websit.entity.T_product_specification;

public class TproductSpecificationVo extends T_product_specification{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
     * 售后信息
     */
    private String after_information;


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


	public String getAfter_information() {
		return after_information;
	}


	public void setAfter_information(String after_information) {
		this.after_information = after_information;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "TproductSpecificationVo [name=" + name + ", product_type_id=" + product_type_id + ", image=" + image
				+ ", state=" + state + ", create_times=" + create_times + ", brand=" + brand + ", describion="
				+ describion + ", zone_id=" + zone_id + ", after_information=" + after_information + "]";
	}
    
    
    
    

}
