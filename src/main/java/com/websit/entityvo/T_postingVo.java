package com.websit.entityvo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @ClassName: T_postingVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年3月14日
 */
public class T_postingVo  implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	 private Long id;

	    /**
	     * 用户id
	     */
	    private Long user_id;

	    /**
	     * 内容
	     */
	    private String context;

	    /**
	     * 标题
	     */
	    private String title;

	    /**
	     * 介绍
	     */
	    private String introduce;

	    /**
	     * 创建时间
	     */
	    private Date create_time;

	    /**
	     * 板块id
	     */
	    private Long plate_id;
	    /**
	     * 昵称
	     */
	    private String nickname;
	    /**
	     * 粉丝数
	     */
	    private Integer fanscount;

	    /**
	     * 关注数
	     */
	    private Integer followcount;
	    /**
	     * 头像
	     */
	    private String avatar;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public Date getCreate_time() {
			return create_time;
		}
		public void setCreate_time(Date create_time) {
			this.create_time = create_time;
		}
		public Long getPlate_id() {
			return plate_id;
		}
		public void setPlate_id(Long plate_id) {
			this.plate_id = plate_id;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Integer getFanscount() {
			return fanscount;
		}
		public void setFanscount(Integer fanscount) {
			this.fanscount = fanscount;
		}
		public Integer getFollowcount() {
			return followcount;
		}
		public void setFollowcount(Integer followcount) {
			this.followcount = followcount;
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
			result = prime * result + ((context == null) ? 0 : context.hashCode());
			result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
			result = prime * result + ((fanscount == null) ? 0 : fanscount.hashCode());
			result = prime * result + ((followcount == null) ? 0 : followcount.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((introduce == null) ? 0 : introduce.hashCode());
			result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
			result = prime * result + ((plate_id == null) ? 0 : plate_id.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			T_postingVo other = (T_postingVo) obj;
			if (avatar == null) {
				if (other.avatar != null)
					return false;
			} else if (!avatar.equals(other.avatar))
				return false;
			if (context == null) {
				if (other.context != null)
					return false;
			} else if (!context.equals(other.context))
				return false;
			if (create_time == null) {
				if (other.create_time != null)
					return false;
			} else if (!create_time.equals(other.create_time))
				return false;
			if (fanscount == null) {
				if (other.fanscount != null)
					return false;
			} else if (!fanscount.equals(other.fanscount))
				return false;
			if (followcount == null) {
				if (other.followcount != null)
					return false;
			} else if (!followcount.equals(other.followcount))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (introduce == null) {
				if (other.introduce != null)
					return false;
			} else if (!introduce.equals(other.introduce))
				return false;
			if (nickname == null) {
				if (other.nickname != null)
					return false;
			} else if (!nickname.equals(other.nickname))
				return false;
			if (plate_id == null) {
				if (other.plate_id != null)
					return false;
			} else if (!plate_id.equals(other.plate_id))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
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
			return "T_postingVo [id=" + id + ", user_id=" + user_id + ", context=" + context + ", title=" + title
					+ ", introduce=" + introduce + ", create_time=" + create_time + ", plate_id=" + plate_id
					+ ", nickname=" + nickname + ", fanscount=" + fanscount + ", followcount=" + followcount
					+ ", avatar=" + avatar + "]";
		}
	    
}
