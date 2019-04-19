package com.websit.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户优惠券关联表
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
public class T_coupon_user extends Model<T_coupon_user> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券id
     */
    private Long coupon_id;

    /**
     * 用户id
     */
    private Long user_id;

    /**
     * 领取时间
     */
    private Date creat_time;

    /**
     * 可用时间
     */
    private Date star_time;

    /**
     * 过期时间
     */
    private Date expiration_time;

    /**
     * 状态（1 未过期， 2 已过期）
     */
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Long coupon_id) {
        this.coupon_id = coupon_id;
    }
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }
    public Date getStar_time() {
        return star_time;
    }

    public void setStar_time(Date star_time) {
        this.star_time = star_time;
    }
    public Date getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(Date expiration_time) {
        this.expiration_time = expiration_time;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_coupon_user{" +
        "id=" + id +
        ", coupon_id=" + coupon_id +
        ", user_id=" + user_id +
        ", creat_time=" + creat_time +
        ", star_time=" + star_time +
        ", expiration_time=" + expiration_time +
        ", state=" + state +
        "}";
    }
}
