package com.websit.entity;

import java.io.Serializable;

public class SpecificationOptions implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 规格选项id
	 */
	private Long id;
	/**
	 * 规格选项id
	 */
	private String name;
	/**
	 * 规格id
	 */
	private Long specificationsId;
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
	public Long getSpecificationsId() {
		return specificationsId;
	}
	public void setSpecificationsId(Long specificationsId) {
		this.specificationsId = specificationsId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpecificationOptions [id=").append(id).append(", name=").append(name)
				.append(", specificationsId=").append(specificationsId).append("]");
		return builder.toString();
	}
	
}
