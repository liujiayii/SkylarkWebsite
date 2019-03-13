package com.websit.entityvo;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 前台用户表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_userVo implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户的电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 访问量
     */
    private Long number;

    /**
     * 创建时间
     */
    private Date create_time;

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
     * 最后登录日期
     */
    private Date lastdate;

    /**
     * 在线时长（分钟）
     */
    private Integer online;

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

    /**
     * 地址
     */
    private String address;
    /**
     * 所有会员数量
     */
    private Long Count;
    /**
     * 所有会员访问量
     */
    private Long Allnumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCount() {
		return Count;
	}
	public void setCount(Long count) {
		Count = count;
	}
	public Long getAllnumber() {
		return Allnumber;
	}
	public void setAllnumber(Long allnumber) {
		Allnumber = allnumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Allnumber == null) ? 0 : Allnumber.hashCode());
		result = prime * result + ((Count == null) ? 0 : Count.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fanscount == null) ? 0 : fanscount.hashCode());
		result = prime * result + ((followcount == null) ? 0 : followcount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastdate == null) ? 0 : lastdate.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((online == null) ? 0 : online.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		T_userVo other = (T_userVo) obj;
		if (Allnumber == null) {
			if (other.Allnumber != null)
				return false;
		} else if (!Allnumber.equals(other.Allnumber))
			return false;
		if (Count == null) {
			if (other.Count != null)
				return false;
		} else if (!Count.equals(other.Count))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (lastdate == null) {
			if (other.lastdate != null)
				return false;
		} else if (!lastdate.equals(other.lastdate))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (online == null) {
			if (other.online != null)
				return false;
		} else if (!online.equals(other.online))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "T_userVo [id=" + id + ", phone=" + phone + ", password=" + password + ", number=" + number
				+ ", create_time=" + create_time + ", nickname=" + nickname + ", sex=" + sex + ", email=" + email
				+ ", lastdate=" + lastdate + ", online=" + online + ", fanscount=" + fanscount + ", followcount="
				+ followcount + ", avatar=" + avatar + ", address=" + address + ", Count=" + Count + ", Allnumber="
				+ Allnumber + "]";
	}
    
}
