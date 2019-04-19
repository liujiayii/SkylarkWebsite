package com.websit.entityvo;

import java.io.Serializable;
import java.util.List;

import com.websit.entity.SpecificationOptions;

public class SpecificationsVo implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 规格id
	 */
	private Long specificationsId;
	/**
	 * 商品类型id
	 */
	private Long producttypeid;
	/**
	 * 商品类型名称
	 */
	private String producttypename;
	/**
	 * 规格名称
	 */
	private String specificationsName;
	/**
	 * 规格所有的规格选项列表
	 */
	private List<SpecificationOptions> SpecificationOptionsList;
	public Long getSpecificationsId() {
		return specificationsId;
	}
	public void setSpecificationsId(Long specificationsId) {
		this.specificationsId = specificationsId;
	}
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
	public String getSpecificationsName() {
		return specificationsName;
	}
	public void setSpecificationsName(String specificationsName) {
		this.specificationsName = specificationsName;
	}
	public List<SpecificationOptions> getSpecificationOptionsList() {
		return SpecificationOptionsList;
	}
	public void setSpecificationOptionsList(List<SpecificationOptions> specificationOptionsList) {
		SpecificationOptionsList = specificationOptionsList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpecificationsVo [specificationsId=").append(specificationsId).append(", producttypeid=")
				.append(producttypeid).append(", producttypename=").append(producttypename)
				.append(", specificationsName=").append(specificationsName).append(", SpecificationOptionsList=")
				.append(SpecificationOptionsList).append("]");
		return builder.toString();
	}
	
	
}
