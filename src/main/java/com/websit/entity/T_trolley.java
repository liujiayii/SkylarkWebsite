package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_trolley extends Model<T_trolley> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "trolley_id", type = IdType.AUTO)
    private Integer trolley_id;

    /**
     * 用户id
     */
    private Integer user_id;

    private Integer product_id;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 时间
     */
    private Date times;

    public Integer getTrolley_id() {
        return trolley_id;
    }

    public void setTrolley_id(Integer trolley_id) {
        this.trolley_id = trolley_id;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    protected Serializable pkVal() {
        return this.trolley_id;
    }

    @Override
    public String toString() {
        return "T_trolley{" +
        "trolley_id=" + trolley_id +
        ", user_id=" + user_id +
        ", product_id=" + product_id +
        ", number=" + number +
        ", times=" + times +
        "}";
    }
}
