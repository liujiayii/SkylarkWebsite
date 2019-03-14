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
	@Override
	public String toString() {
		return "UserRegister [phone=" + phone + ", code=" + code + ", msgcode=" + msg_code + ", password=" + password
				+ "]";
	}
	

}
