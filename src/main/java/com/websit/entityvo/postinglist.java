package com.websit.entityvo;

import java.util.Date;
import java.util.List;

/**
 * 查询回复列表的实体类
 * 
 * @author xxx
 *
 */
public class postinglist {
	/**
	 * id
	 */
	private String id;
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
	/**
	 * 用户id
	 */
	private String user_id;
	/**
	 * 更新时间
	 */
	private Date create_time;
	/**
	 * 查询总量
	 */
	private int num2;

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	private List<T_replylist> T_replylist;

	public List<T_replylist> getT_replylist() {
		return T_replylist;
	}

	public void setT_replylist(List<T_replylist> t_replylist) {
		T_replylist = t_replylist;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "postinglist [id=" + id + ", nickname=" + nickname + ", avatar=" + avatar + ", comment=" + comment
				+ ", user_id=" + user_id + ", create_time=" + create_time + ", T_replylist=" + T_replylist + "]";
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
