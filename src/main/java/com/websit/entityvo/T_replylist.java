package com.websit.entityvo;

import java.util.Date;

import com.websit.entity.T_reply;

public class T_replylist {
    /* 昵称
    */
   private String nickname;
   /**
    * 回复头像
    */
   private String avatar;
   /**
    * 回复内容
    * @return
    */
   private String response;

   /**
    * 创建时间
    */
   private Date create_time;
   /* 被回复昵称
   */
  private String bnickname;
  /**
   * 用户id
   */
  private Long user_id;

  /**
   * 被回复人id
   */
  private Long users_id;
  
  
  
  public String getNickname() {
	return nickname;
}



public void setNickname(String nickname) {
	this.nickname = nickname;
}



public String getAvatar() {
	return avatar;
}



public void setAvatar(String avatar) {
	this.avatar = avatar;
}



public String getResponse() {
	return response;
}



public void setResponse(String response) {
	this.response = response;
}



public Date getCreate_time() {
	return create_time;
}



public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}



public String getBnickname() {
	return bnickname;
}



public void setBnickname(String bnickname) {
	this.bnickname = bnickname;
}



public Long getUser_id() {
	return user_id;
}



public void setUser_id(Long user_id) {
	this.user_id = user_id;
}



public Long getUsers_id() {
	return users_id;
}



public void setUsers_id(Long users_id) {
	this.users_id = users_id;
}



@Override
public String toString() {
	return "T_replylist [nickname=" + nickname + ", avatar=" + avatar + ", response=" + response + ", create_time="
			+ create_time + ", bnickname=" + bnickname + ", user_id=" + user_id + ", users_id=" + users_id + "]";
}
}
