package com.websit.entityvo;

import java.io.Serializable;
import java.util.List;


public class ProductTypeSpecifications implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品类型id
	 */
	private Long producttypeid;
	/**
	 * 商品类型名称
	 */
	private String producttypename;
	/**
	 * 商品所属的规格列表
	 */
	private List<SpecificationsVo> SpecificationOptionsListss;
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
	public List<SpecificationsVo> getSpecificationOptionsListss() {
		return SpecificationOptionsListss;
	}
	public void setSpecificationOptionsListss(List<SpecificationsVo> specificationOptionsListss) {
		SpecificationOptionsListss = specificationOptionsListss;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductTypeSpecifications [producttypeid=").append(producttypeid).append(", producttypename=")
				.append(producttypename).append(", SpecificationOptionsListss=").append(SpecificationOptionsListss)
				.append("]");
		return builder.toString();
	}
	

}
