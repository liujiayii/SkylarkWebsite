package com.websit.entityvo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import com.websit.entity.T_product;
/**
 * @ClassName: ProductTypeVo
 * @description 用于展示商品类型及每个类型下商品列表的实体类
 * @author pangchong
 * @createDate 2019年3月21日
 */
public class ProductTypeVo implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	 /**
     * 商品类型id
     */
    private Long productTypeId;

    /**
     * 商品类型名称
     */
    private String productTypeName;

    /**
     * 创建时间
     */
    private Date create_time;
    
    /**
     * 每个类型下商品列表
     */
    List<T_product>productList;
	public Long getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public List<T_product> getProductList() {
		return productList;
	}
	public void setProductList(List<T_product> productList) {
		this.productList = productList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((productTypeId == null) ? 0 : productTypeId.hashCode());
		result = prime * result + ((productTypeName == null) ? 0 : productTypeName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductTypeVo other = (ProductTypeVo) obj;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (productTypeId == null) {
			if (other.productTypeId != null)
				return false;
		} else if (!productTypeId.equals(other.productTypeId))
			return false;
		if (productTypeName == null) {
			if (other.productTypeName != null)
				return false;
		} else if (!productTypeName.equals(other.productTypeName))
			return false;
		return true;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	
	* @param productTypeId
	* @param productTypeName
	* @param create_time
	* @param productList  
	
	*/  
	public ProductTypeVo(Long productTypeId, String productTypeName, Date create_time, List<T_product> productList) {
		super();
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.create_time = create_time;
		this.productList = productList;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ProductTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
