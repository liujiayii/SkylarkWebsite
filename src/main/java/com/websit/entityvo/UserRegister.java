package com.websit.entityvo;



/**
 * 
 *
 * @ClassName: UserRegister

 * @description 用户注册
 *
 * @author lishaozhang
 * @createDate 2019年3月13日
 */
public class UserRegister {

	private String phone;
	private String code;
	private String msg_code;
	private String password;
	private Integer cilent;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCilent() {
		return cilent;
	}
	public void setCilent(Integer cilent) {
		this.cilent = cilent;
	}
	@Override
	public String toString() {
		return "UserRegister [phone=" + phone + ", code=" + code + ", msgcode=" + msg_code + ", password=" + password
				+ "]";
	}
	

}
