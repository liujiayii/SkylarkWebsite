package com.websit.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class OurAdvantages implements Serializable{

	/**
	 * 序列化啊
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private BigInteger id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public OurAdvantages() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OurAdvantages [id=").append(id).append(", title=").append(title).append(", content=")
				.append(content).append("]");
		return builder.toString();
	}
	
}
