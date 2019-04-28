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
    private String user_id;

    private String product_id;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 时间
     */
    private Date times;
    /**
     * 时间
     */
    private String  trolley_specifications;
    /**
     * 时间
     */
    private double trolley_price;
    /*-*
     * 规格id
     */
    private String T_product_specification_id;
    

    public String getT_product_specification_id() {
		return T_product_specification_id;
	}

	public void setT_product_specification_id(String t_product_specification_id) {
		T_product_specification_id = t_product_specification_id;
	}

	public String getTrolley_specifications() {
		return trolley_specifications;
	}

	public void setTrolley_specifications(String trolley_specifications) {
		this.trolley_specifications = trolley_specifications;
	}

	public double getTrolley_price() {
		return trolley_price;
	}

	public void setTrolley_price(double trolley_price) {
		this.trolley_price = trolley_price;
	}

	public Integer getTrolley_id() {
        return trolley_id;
    }

    public void setTrolley_id(Integer trolley_id) {
        this.trolley_id = trolley_id;
    }

    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


    public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
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
		return "T_trolley [trolley_id=" + trolley_id + ", user_id=" + user_id + ", product_id=" + product_id
				+ ", number=" + number + ", times=" + times + ", trolley_specifications=" + trolley_specifications
				+ ", trolley_price=" + trolley_price + ", T_product_specification_id=" + T_product_specification_id
				+ "]";
	}
}
