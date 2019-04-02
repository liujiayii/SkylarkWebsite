package com.websit.entityvo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
/**
 * 个人贴吧详细信息实体类
 *
 * @author pangchong
 * @createDate 2018年9月12日 上午10:30
 */
public class Personal implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	//用户id
	private BigInteger id;
	//访问量
	private BigInteger traffic;
	//用户创建时间
	private Date userCreate_time;
	//用户昵称
	private String nickName;
	//性别
	private String sex;
	//邮箱
	private String email;
	//用户粉丝数量
	private int fansCount;
	//用户关注数量
	private int followCount;
	//用户头像
	private String avatar;
	//用户地址
	private String address;
	//论坛版块名称
	private String plateName;
	//论坛版块介绍
	private String plateIntroduce;
	//发贴贴子内容
	private String postingContext;
	//贴子标题
	private String postingTitle;
	//贴子介绍
	private String postingIntroduce;
	//贴子发布时间
	private Date postingCreate_time;
	//用户签名
	private String userSignature;
	//用户生日
	private Date userBirthday;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getTraffic() {
		return traffic;
	}
	public void setTraffic(BigInteger traffic) {
		this.traffic = traffic;
	}
	public Date getUserCreate_time() {
		return userCreate_time;
	}
	public void setUserCreate_time(Date userCreate_time) {
		this.userCreate_time = userCreate_time;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	public int getFollowCount() {
		return followCount;
	}
	public void setFollowCount(int followCount) {
		this.followCount = followCount;
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
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public String getPlateIntroduce() {
		return plateIntroduce;
	}
	public void setPlateIntroduce(String plateIntroduce) {
		this.plateIntroduce = plateIntroduce;
	}
	public String getPostingContext() {
		return postingContext;
	}
	public void setPostingContext(String postingContext) {
		this.postingContext = postingContext;
	}
	public String getPostingTitle() {
		return postingTitle;
	}
	public void setPostingTitle(String postingTitle) {
		this.postingTitle = postingTitle;
	}
	public String getPostingIntroduce() {
		return postingIntroduce;
	}
	public void setPostingIntroduce(String postingIntroduce) {
		this.postingIntroduce = postingIntroduce;
	}
	public Date getPostingCreate_time() {
		return postingCreate_time;
	}
	public void setPostingCreate_time(Date postingCreate_time) {
		this.postingCreate_time = postingCreate_time;
	}
	public String getUserSignature() {
		return userSignature;
	}
	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + fansCount;
		result = prime * result + followCount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((plateIntroduce == null) ? 0 : plateIntroduce.hashCode());
		result = prime * result + ((plateName == null) ? 0 : plateName.hashCode());
		result = prime * result + ((postingContext == null) ? 0 : postingContext.hashCode());
		result = prime * result + ((postingCreate_time == null) ? 0 : postingCreate_time.hashCode());
		result = prime * result + ((postingIntroduce == null) ? 0 : postingIntroduce.hashCode());
		result = prime * result + ((postingTitle == null) ? 0 : postingTitle.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((traffic == null) ? 0 : traffic.hashCode());
		result = prime * result + ((userBirthday == null) ? 0 : userBirthday.hashCode());
		result = prime * result + ((userCreate_time == null) ? 0 : userCreate_time.hashCode());
		result = prime * result + ((userSignature == null) ? 0 : userSignature.hashCode());
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
		Personal other = (Personal) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fansCount != other.fansCount)
			return false;
		if (followCount != other.followCount)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (plateIntroduce == null) {
			if (other.plateIntroduce != null)
				return false;
		} else if (!plateIntroduce.equals(other.plateIntroduce))
			return false;
		if (plateName == null) {
			if (other.plateName != null)
				return false;
		} else if (!plateName.equals(other.plateName))
			return false;
		if (postingContext == null) {
			if (other.postingContext != null)
				return false;
		} else if (!postingContext.equals(other.postingContext))
			return false;
		if (postingCreate_time == null) {
			if (other.postingCreate_time != null)
				return false;
		} else if (!postingCreate_time.equals(other.postingCreate_time))
			return false;
		if (postingIntroduce == null) {
			if (other.postingIntroduce != null)
				return false;
		} else if (!postingIntroduce.equals(other.postingIntroduce))
			return false;
		if (postingTitle == null) {
			if (other.postingTitle != null)
				return false;
		} else if (!postingTitle.equals(other.postingTitle))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (traffic == null) {
			if (other.traffic != null)
				return false;
		} else if (!traffic.equals(other.traffic))
			return false;
		if (userBirthday == null) {
			if (other.userBirthday != null)
				return false;
		} else if (!userBirthday.equals(other.userBirthday))
			return false;
		if (userCreate_time == null) {
			if (other.userCreate_time != null)
				return false;
		} else if (!userCreate_time.equals(other.userCreate_time))
			return false;
		if (userSignature == null) {
			if (other.userSignature != null)
				return false;
		} else if (!userSignature.equals(other.userSignature))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personal [id=").append(id).append(", traffic=").append(traffic).append(", userCreate_time=")
				.append(userCreate_time).append(", nickName=").append(nickName).append(", sex=").append(sex)
				.append(", email=").append(email).append(", fansCount=").append(fansCount).append(", followCount=")
				.append(followCount).append(", avatar=").append(avatar).append(", address=").append(address)
				.append(", plateName=").append(plateName).append(", plateIntroduce=").append(plateIntroduce)
				.append(", postingContext=").append(postingContext).append(", postingTitle=").append(postingTitle)
				.append(", postingIntroduce=").append(postingIntroduce).append(", postingCreate_time=")
				.append(postingCreate_time).append(", userSignature=").append(userSignature).append(", userBirthday=")
				.append(userBirthday).append("]");
		return builder.toString();
	}
	
	
}
