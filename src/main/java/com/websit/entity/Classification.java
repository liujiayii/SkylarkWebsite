package com.websit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.websit.entity.T_product_type;

public class Classification extends Model<Classification>{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品一级分类id
	 */
	private Long id;
	/**
	 * 商品一级分类名称
	 */
	private String name;
	/**
	 * 商品一级分类图片
	 */
	private String image;
	/**
	 * 商品一级分类名称
	 */
	private Date create_time;
	@Override
	protected Serializable pkVal() {
		
		return this.id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Classification() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Classification [id=").append(id).append(", name=").append(name).append(", image=").append(image)
				.append(", create_time=").append(create_time).append("]");
		return builder.toString();
	}

}
