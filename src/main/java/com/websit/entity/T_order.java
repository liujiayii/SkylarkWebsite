package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_order extends Model<T_order> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer order_id;

    /**
     * 商品id
     */
    private String order_product_id;

    /**
     * 数量
     */
    private String order_number;

    /**
     * 订单金额
     */
    private Double order_money;
   /**
    * 订单编号
    */
    private String order_no;

    /**
     * 状态
     */
    private String order_state;

    /**
     * 订单时间
     */
    private Date order_time;

    /**
     * 支付方式
     */
    private String order_payment;

    /**
     * 配送地址
     */
    private String order_mode;

    /**
     * 物流id
     */
    private String order_shouhuo_id;
    
    /**
     * 用户id
     */
    private String user_id;
    

    /**
     * 运费
     */
    private String yunfei;
    /**
     * 备注
     */
    private String remarks;
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getYunfei() {
		return yunfei;
	}

	public void setYunfei(String yunfei) {
		this.yunfei = yunfei;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    public String getOrder_product_id() {
        return order_product_id;
    }

    public void setOrder_product_id(String order_product_id) {
        this.order_product_id = order_product_id;
    }
    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }
    public Double getOrder_money() {
        return order_money;
    }

    public void setOrder_money(Double order_money) {
        this.order_money = order_money;
    }
    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }
    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }
    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }
    public String getOrder_payment() {
        return order_payment;
    }

    public void setOrder_payment(String order_payment) {
        this.order_payment = order_payment;
    }
    public String getOrder_mode() {
        return order_mode;
    }

    public void setOrder_mode(String order_mode) {
        this.order_mode = order_mode;
    }
    public String getOrder_shouhuo_id() {
        return order_shouhuo_id;
    }

    public void setOrder_shouhuo_id(String order_shouhuo_id) {
        this.order_shouhuo_id = order_shouhuo_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.order_id;
    }

    @Override
	public String toString() {
		return "T_order [order_id=" + order_id + ", order_product_id=" + order_product_id + ", order_number="
				+ order_number + ", order_money=" + order_money + ", order_no=" + order_no + ", order_state="
				+ order_state + ", order_time=" + order_time + ", order_payment=" + order_payment + ", order_mode="
				+ order_mode + ", order_shouhuo_id=" + order_shouhuo_id + ", user_id=" + user_id + ", yunfei=" + yunfei
				+ ", remarks=" + remarks + "]";
	}
}
