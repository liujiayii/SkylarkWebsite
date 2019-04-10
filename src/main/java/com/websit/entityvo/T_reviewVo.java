package com.websit.entityvo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.websit.entity.T_picture_video;

/**
 *
 * @ClassName: T_reviewVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年3月21日
 */
public class T_reviewVo implements Serializable{

	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
     * 评论表的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品表的id
     */
    private Long product_id;

    /**
     * 买家id
     */
    private String user_id;

    /**
     * 买家评论内容
     */
    private String review_content;

    /**
     * 买家评论时间
     */
    private Date review_time;

    /**
     * 商家回复
     */
    private String reply;

    /**
     * 商家回复时间
     */
    private Date reply_time;

    /**
     * 浏览量
     */
    private Long browse_number;

    /**
     * 评价分数(1.很差 2.差 3.好 4.很好 5.非常好)
     */
    private Long appraise;
    /**
     * 商品名称
     */
    private String name;

    /**
     * 图片
     */
    private String image;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 颜色
     */
    private String color;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 商品描述
     */
    private String describe;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 图片路径
     */
    private String picture;

    /**
     * 视频路径
     */
    private String video;
    /**
     * 商品表评论id
     */
    private Long review_id;
    /** 页数 */
	private int page=1;
	/** 分页条数 */
	private int limit=5;
	/** 图片集合 */
	private List<T_picture_video> picture_video;
	
	public List<T_picture_video> getPicture_video() {
		return picture_video;
	}

	public void setPicture_video(List<T_picture_video> picture_video) {
		this.picture_video = picture_video;
	}

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

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public Date getReview_time() {
		return review_time;
	}

	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public Long getBrowse_number() {
		return browse_number;
	}

	public void setBrowse_number(Long browse_number) {
		this.browse_number = browse_number;
	}

	public Long getAppraise() {
		return appraise;
	}

	public void setAppraise(Long appraise) {
		this.appraise = appraise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appraise == null) ? 0 : appraise.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((browse_number == null) ? 0 : browse_number.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result + ((reply_time == null) ? 0 : reply_time.hashCode());
		result = prime * result + ((review_content == null) ? 0 : review_content.hashCode());
		result = prime * result + ((review_id == null) ? 0 : review_id.hashCode());
		result = prime * result + ((review_time == null) ? 0 : review_time.hashCode());
		result = prime * result + ((specifications == null) ? 0 : specifications.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		T_reviewVo other = (T_reviewVo) obj;
		if (appraise == null) {
			if (other.appraise != null)
				return false;
		} else if (!appraise.equals(other.appraise))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (browse_number == null) {
			if (other.browse_number != null)
				return false;
		} else if (!browse_number.equals(other.browse_number))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (reply_time == null) {
			if (other.reply_time != null)
				return false;
		} else if (!reply_time.equals(other.reply_time))
			return false;
		if (review_content == null) {
			if (other.review_content != null)
				return false;
		} else if (!review_content.equals(other.review_content))
			return false;
		if (review_id == null) {
			if (other.review_id != null)
				return false;
		} else if (!review_id.equals(other.review_id))
			return false;
		if (review_time == null) {
			if (other.review_time != null)
				return false;
		} else if (!review_time.equals(other.review_time))
			return false;
		if (specifications == null) {
			if (other.specifications != null)
				return false;
		} else if (!specifications.equals(other.specifications))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "T_reviewVo [id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", review_content="
				+ review_content + ", review_time=" + review_time + ", reply=" + reply + ", reply_time=" + reply_time
				+ ", browse_number=" + browse_number + ", appraise=" + appraise + ", name=" + name + ", image=" + image
				+ ", price=" + price + ", color=" + color + ", brand=" + brand + ", specifications=" + specifications
				+ ", describe=" + describe + ", nickname=" + nickname + ", avatar=" + avatar + ", picture=" + picture
				+ ", video=" + video + ", review_id=" + review_id + "]";
	}
	

}
