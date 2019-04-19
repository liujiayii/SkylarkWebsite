package com.websit.entity;

import java.io.Serializable;

public class Brand implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 品牌id
	 */
	private Long id;
	/**
	 * 品牌名称
	 */
	private String name;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Brand [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}
	
}
