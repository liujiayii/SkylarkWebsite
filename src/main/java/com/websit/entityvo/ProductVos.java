package com.websit.entityvo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.websit.entity.T_product_type;


public class ProductVos extends Model<ProductVos>{
	 /**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
	private Long classificationId;
	/**
     * 商品大分类名称
     */
	private String classificationName;
	/**
     * 商品大分类名称
     */
	private Date createTime;
	/**
     * 商品大分类图片
     */
	private String classificationImage;
	 /**
     * 每个大类型下商品类型列表
     */
    List<T_product_type>productTypeList;
	@Override
	protected Serializable pkVal() {
	
		return this.classificationId;
	}
	public Long getClassificationId() {
		return classificationId;
	}
	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}
	public String getClassificationName() {
		return classificationName;
	}
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getClassificationImage() {
		return classificationImage;
	}
	public void setClassificationImage(String classificationImage) {
		this.classificationImage = classificationImage;
	}
	public List<T_product_type> getProductTypeList() {
		return productTypeList;
	}
	public void setProductTypeList(List<T_product_type> productTypeList) {
		this.productTypeList = productTypeList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ProductVos() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductVos [classificationId=").append(classificationId).append(", classificationName=")
				.append(classificationName).append(", createTime=").append(createTime).append(", classificationImage=")
				.append(classificationImage).append(", productTypeList=").append(productTypeList).append("]");
		return builder.toString();
	}
	
}
