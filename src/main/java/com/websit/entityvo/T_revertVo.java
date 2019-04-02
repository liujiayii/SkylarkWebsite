package com.websit.entityvo;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *
 * @ClassName: T_revertVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年3月22日
 */
public class T_revertVo implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
     * 商品评论回复表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论表id
     */
    private Long review_id;

    /**
     * 回复人id
     */
    private Long user_id;

    /**
     * 被回复人id
     */
    private Long byuser_id;

    /**
     * 回复内容
     */
    private String revert;

    /**
     * 回复时间
     */
    private Date revert_time;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 被回复昵称
     */
    private String bynickname;
    /**
     * 头像
     */
    private String avatar;
    /** 页数 */
	private int page=0;
	/** 分页条数 */
	private int limit=5;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getBynickname() {
		return bynickname;
	}
	public void setBynickname(String bynickname) {
		this.bynickname = bynickname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReview_id() {
		return review_id;
	}
	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getByuser_id() {
		return byuser_id;
	}
	public void setByuser_id(Long byuser_id) {
		this.byuser_id = byuser_id;
	}
	public String getRevert() {
		return revert;
	}
	public void setRevert(String revert) {
		this.revert = revert;
	}
	public Date getRevert_time() {
		return revert_time;
	}
	public void setRevert_time(Date revert_time) {
		this.revert_time = revert_time;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((bynickname == null) ? 0 : bynickname.hashCode());
		result = prime * result + ((byuser_id == null) ? 0 : byuser_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + limit;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + page;
		result = prime * result + ((revert == null) ? 0 : revert.hashCode());
		result = prime * result + ((revert_time == null) ? 0 : revert_time.hashCode());
		result = prime * result + ((review_id == null) ? 0 : review_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T_revertVo other = (T_revertVo) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (bynickname == null) {
			if (other.bynickname != null)
				return false;
		} else if (!bynickname.equals(other.bynickname))
			return false;
		if (byuser_id == null) {
			if (other.byuser_id != null)
				return false;
		} else if (!byuser_id.equals(other.byuser_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (limit != other.limit)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (page != other.page)
			return false;
		if (revert == null) {
			if (other.revert != null)
				return false;
		} else if (!revert.equals(other.revert))
			return false;
		if (revert_time == null) {
			if (other.revert_time != null)
				return false;
		} else if (!revert_time.equals(other.revert_time))
			return false;
		if (review_id == null) {
			if (other.review_id != null)
				return false;
		} else if (!review_id.equals(other.review_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "T_revertVo [id=" + id + ", review_id=" + review_id + ", user_id=" + user_id + ", byuser_id=" + byuser_id
				+ ", revert=" + revert + ", revert_time=" + revert_time + ", nickname=" + nickname + ", bynickname="
				+ bynickname + ", avatar=" + avatar + ", page=" + page + ", limit=" + limit + "]";
	}
    
}
