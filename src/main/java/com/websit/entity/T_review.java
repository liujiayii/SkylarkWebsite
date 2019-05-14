package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.websit.until.Security;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品评论表(蔺)
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public class T_review extends Model<T_review> {

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
     * 评价分数
(1.很差
 2.差
 3.好
 4.很好
 5.非常好
)
     */
    private Long appraise;

    /**
     * 图片路径
     */
    private String picture;
    public int getShopping_id() {
		return shopping_id;
	}

	public void setShopping_id(int shopping_id) {
		this.shopping_id = shopping_id;
	}

	/**
     * 商品订单id
     */
    private int shopping_id;

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
        this.user_id =user_id;
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
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
	public String toString() {
		return "T_review [id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", review_content="
				+ review_content + ", review_time=" + review_time + ", reply=" + reply + ", reply_time=" + reply_time
				+ ", browse_number=" + browse_number + ", appraise=" + appraise + ", picture=" + picture
				+ ", shopping_id=" + shopping_id + "]";
	}
}
