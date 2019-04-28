package com.websit.entityvo;
/**
 * 
 *
 * @ClassName: CouponUserFind

 * @description 购买商品是给用户返回的当前可用优惠券类
 *
 * @author lishaozhang
 * @createDate 2019年4月20日
 */

import java.util.Date;
public class CouponUserFind {
//优惠券与客户绑定表的主键id
	private Long Coupon_user_id;
	
	//优惠券图片
	private String icon;
	
	//优惠券标题说明
	private String title;
	
	//优惠券过期时间
	private Date expiration_time;

	public Long getCoupon_user_id() {
		return Coupon_user_id;
	}

	public void setCoupon_user_id(Long coupon_user_id) {
		Coupon_user_id = coupon_user_id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getExpiration_time() {
		return expiration_time;
	}

	public void setExpiration_time(Date expiration_time) {
		this.expiration_time = expiration_time;
	}

	public CouponUserFind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponUserFind(Long coupon_user_id, String icon, String title, Date expiration_time) {
		super();
		Coupon_user_id = coupon_user_id;
		this.icon = icon;
		this.title = title;
		this.expiration_time = expiration_time;
	}

	@Override
	public String toString() {
		return "CouponUserFind [Coupon_user_id=" + Coupon_user_id + ", icon=" + icon + ", title=" + title
				+ ", expiration_time=" + expiration_time + "]";
	}
	
	
}
