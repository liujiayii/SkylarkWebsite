package com.websit.entity;

import java.util.Date;
/**
 * 
 *
 * @ClassName: UserUpdateVo

 * @description 修改用户信息vo类
 *
 * @author lishaozhang
 * @createDate 2019年3月22日
 */
public class UserUpdateVo {
	
	 private Long id;
	 
	 /**
	     * 昵称
	     */
	    private String nickname;

	    /**
	     * 性别
	     */
	    private String sex;

	    /**
	     * 邮箱
	     */
	    private String email;
	    
	    /**
	     * 头像
	     */
	    private String avatar;
	    	    
	    /**
	     * 出生日期
	     */
	    private Date birthday;
	    
	    /**
	     * 签名
	     */
	    private String signature;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

		@Override
		public String toString() {
			return "UserUpdateVo [id=" + id + ", nickname=" + nickname + ", sex=" + sex + ", email=" + email
					+ ", avatar=" + avatar + ", birthday=" + birthday + ", signature=" + signature + "]";
		}

	
}
