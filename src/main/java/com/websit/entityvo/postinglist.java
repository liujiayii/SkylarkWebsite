package com.websit.entityvo;
/**
 * 查询回复列表的实体类
 * @author xxx
 *
 */
public class postinglist {
/**
 * 用户id
 */
private  String id ;
/**
 * 昵称
 */
private String nickname;
/**
 * 头像
 */
private String avatar;
/**
 * 评论内容
 */
private String comment;
@Override
public String toString() {
	return "postinglist [id=" + id + ", nickname=" + nickname + ", avatar=" + avatar + ", comment=" + comment + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
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
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
}
