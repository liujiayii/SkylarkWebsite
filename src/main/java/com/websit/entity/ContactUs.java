package com.websit.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class ContactUs implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private BigInteger id;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 企业邮箱
	 */
	private String enterprise_email;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEnterprise_email() {
		return enterprise_email;
	}
	public void setEnterprise_email(String enterprise_email) {
		this.enterprise_email = enterprise_email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactUs [id=").append(id).append(", address=").append(address).append(", phone=")
				.append(phone).append(", enterprise_email=").append(enterprise_email).append("]");
		return builder.toString();
	}
	
	
}
