package com.websit.entityvo;

import com.websit.entity.T_product;
import com.websit.entity.T_trolley;

/**
 * 购物车列表
 * @author xxx
 *
 */
public class lt_trolleylst  extends  T_trolley {


	/**
	 * 优惠金额
	 */
	private  String youhuijine;

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
     * 
     */
    public Integer numbers;
	public Integer getNumbers() {
		return numbers;
	}



	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}



	@Override
	public String toString() {
		return "lt_trolleylst [youhuijine=" + youhuijine + ", id=" + id + ", name=" + name + ", product_type_id="
				+ product_type_id + ", image=" + image + ", numbers=" + numbers + "]";
	}

	

	public String getYouhuijine() {
		return youhuijine;
	}

	public void setYouhuijine(String youhuijine) {
		this.youhuijine = youhuijine;
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
	
   
}
