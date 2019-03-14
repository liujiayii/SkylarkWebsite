package com.websit.entityvo;
/**
 * 
 *
 * @ClassName: Logivo

 * @description 登陆信息实体类
 *
 * @author lishaozhang
 * @createDate 2019年3月14日
 */
public class Logivo {
	private String phone;
	private String password; 
	private String code;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Logivo [phone=" + phone + ", password=" + password + ", code=" + code + "]";
	}
	
}
