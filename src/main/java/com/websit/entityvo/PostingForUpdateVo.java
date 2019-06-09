package com.websit.entityvo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @ClassName: PostingForUpdateVo
 * @description 修改帖子“置顶、精华、删除”状态的实体类
 *
 * @author dujiawei
 * @createDate 2019年6月3日
 */
public class PostingForUpdateVo implements Serializable {

	/** UID  */
	private static final long serialVersionUID = 1L;
	/** id */
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
     * 是否精华帖子（0.否，1.是）
     */
    private Integer is_good;
    /**
     * 设置精华帖时间
     */
    private Date toGood_time;
    /**
     * 最新更新时间
     */
    private Date new_time;
    /** 浏览量 */
   	private Integer number;
    /**
     * 是否置顶(0.不置顶  1.置顶)
     */
    private Integer is_top;

    /**
     * 是否删除  1：显示 0表示删除
     */
    private Integer is_dele;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the introduce
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce the introduce to set
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the plate_id
	 */
	public Long getPlate_id() {
		return plate_id;
	}

	/**
	 * @param plate_id the plate_id to set
	 */
	public void setPlate_id(Long plate_id) {
		this.plate_id = plate_id;
	}

	/**
	 * @return the is_good
	 */
	public Integer getIs_good() {
		return is_good;
	}

	/**
	 * @param is_good the is_good to set
	 */
	public void setIs_good(Integer is_good) {
		this.is_good = is_good;
	}

	/**
	 * @return the toGood_time
	 */
	public Date getToGood_time() {
		return toGood_time;
	}

	/**
	 * @param toGood_time the toGood_time to set
	 */
	public void setToGood_time(Date toGood_time) {
		this.toGood_time = toGood_time;
	}

	/**
	 * @return the new_time
	 */
	public Date getNew_time() {
		return new_time;
	}

	/**
	 * @param new_time the new_time to set
	 */
	public void setNew_time(Date new_time) {
		this.new_time = new_time;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the is_top
	 */
	public Integer getIs_top() {
		return is_top;
	}

	/**
	 * @param is_top the is_top to set
	 */
	public void setIs_top(Integer is_top) {
		this.is_top = is_top;
	}

	/**
	 * @return the is_dele
	 */
	public Integer getIs_dele() {
		return is_dele;
	}

	/**
	 * @param is_dele the is_dele to set
	 */
	public void setIs_dele(Integer is_dele) {
		this.is_dele = is_dele;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((introduce == null) ? 0 : introduce.hashCode());
		result = prime * result + ((is_dele == null) ? 0 : is_dele.hashCode());
		result = prime * result + ((is_good == null) ? 0 : is_good.hashCode());
		result = prime * result + ((is_top == null) ? 0 : is_top.hashCode());
		result = prime * result + ((new_time == null) ? 0 : new_time.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((plate_id == null) ? 0 : plate_id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toGood_time == null) ? 0 : toGood_time.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostingForUpdateVo other = (PostingForUpdateVo) obj;
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
		if (is_dele == null) {
			if (other.is_dele != null)
				return false;
		} else if (!is_dele.equals(other.is_dele))
			return false;
		if (is_good == null) {
			if (other.is_good != null)
				return false;
		} else if (!is_good.equals(other.is_good))
			return false;
		if (is_top == null) {
			if (other.is_top != null)
				return false;
		} else if (!is_top.equals(other.is_top))
			return false;
		if (new_time == null) {
			if (other.new_time != null)
				return false;
		} else if (!new_time.equals(other.new_time))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
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
		if (toGood_time == null) {
			if (other.toGood_time != null)
				return false;
		} else if (!toGood_time.equals(other.toGood_time))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostingForUpdateVo [id=" + id + ", user_id=" + user_id + ", context=" + context + ", title=" + title
				+ ", introduce=" + introduce + ", create_time=" + create_time + ", plate_id=" + plate_id + ", is_good="
				+ is_good + ", toGood_time=" + toGood_time + ", new_time=" + new_time + ", number=" + number
				+ ", is_top=" + is_top + ", is_dele=" + is_dele + "]";
	}
    

}
