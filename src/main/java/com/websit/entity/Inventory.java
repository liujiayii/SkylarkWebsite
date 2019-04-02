package com.websit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Inventory extends Model<Inventory>{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 库存id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品库存数量
     */
    private int number;
    /**
     * 商品id
     */
    private Long products_id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 创建时间
     */
    private Date create_time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Long getProducts_id() {
		return products_id;
	}
	public void setProducts_id(Long products_id) {
		this.products_id = products_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [id=").append(id).append(", number=").append(number).append(", products_id=")
				.append(products_id).append(", productName=").append(productName).append(", create_time=")
				.append(create_time).append("]");
		return builder.toString();
	}
	@Override
	protected Serializable pkVal() {
	
		return this.id;
	}
	
}
