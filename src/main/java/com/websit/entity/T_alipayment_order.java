package com.websit.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商户支付宝订单
 * </p>
 *
 * @author lujinpeng
 * @since 2019-03-27
 */
public class T_alipayment_order extends Model<T_alipayment_order> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 商家订单主键
     */
    private Long order_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 通知时间
     */
    private Date notify_time;

    /**
     * 交易创建时间
     */
    private Date gmt_create;

    /**
     * 交易付款时间
     */
    private Date gmt_payment;

    /**
     * 交易退款时间
     */
    private Date gmt_refund;

    /**
     * 交易结束时间
     */
    private Date gmt_close;

    /**
     * 支付宝的交易号
     */
    private String trade_no;

    /**
     * 商户业务号(商户业务ID，主要是退款通知中返回退款申请的流水号)
     */
    private String out_biz_no;

    /**
     * 卖家支付宝账号
     */
    private String seller_email;

    /**
     * 卖家支付宝用户号
     */
    private String seller_id;

    /**
     * 买家支付宝账号
     */
    private String buyer_logon_id;

    /**
     * 订单金额
     */
    private Double total_amount;

    /**
     * 实收金额
     */
    private Double receipt_amount;

    /**
     * 付款金额:用户在交易中支付的金额
     */
    private Double buyer_pay_amount;
    
    /**
     * 总退款金额
     */
    private Double refund_fee;

    /**
     * 交易状态
     */
    private Integer trade_status;
    
    /**
     * 买家支付宝账号对应的支付宝唯一用户号
     */
    private String buyer_id;
    
    /**
     * 本次退款是否发生了资金变化
     */
    private String fund_change;
    
    /**
     * 交易在支付时候的门店名称
     */
    private String store_name;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public Date getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(Date notify_time) {
        this.notify_time = notify_time;
    }
    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
    public Date getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(Date gmt_payment) {
        this.gmt_payment = gmt_payment;
    }
    public Date getGmt_refund() {
        return gmt_refund;
    }

    public void setGmt_refund(Date gmt_refund) {
        this.gmt_refund = gmt_refund;
    }
    public Date getGmt_close() {
        return gmt_close;
    }

    public void setGmt_close(Date gmt_close) {
        this.gmt_close = gmt_close;
    }
    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }
    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }
    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }
    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }
    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }
    public Double getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(Double receipt_amount) {
        this.receipt_amount = receipt_amount;
    }
    public Double getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(Double buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }
    public Integer getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(Integer trade_status) {
        this.trade_status = trade_status;
    }

    public Double getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Double refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getFund_change() {
		return fund_change;
	}

	public void setFund_change(String fund_change) {
		this.fund_change = fund_change;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	@Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_alipayment_order{" +
        "id=" + id +
        ", order_id=" + order_id +
        ", out_trade_no=" + out_trade_no +
        ", notify_time=" + notify_time +
        ", gmt_create=" + gmt_create +
        ", gmt_payment=" + gmt_payment +
        ", gmt_refund=" + gmt_refund +
        ", gmt_close=" + gmt_close +
        ", trade_no=" + trade_no +
        ", out_biz_no=" + out_biz_no +
        ", seller_email=" + seller_email +
        ", seller_id=" + seller_id +
        ", buyer_logon_id=" + buyer_logon_id +
        ", total_amount=" + total_amount +
        ", receipt_amount=" + receipt_amount +
        ", buyer_pay_amount=" + buyer_pay_amount +
        ", trade_status=" + trade_status +
        ", refund_fee=" + refund_fee +
        ", buyer_id=" + buyer_id +
        ", fund_change=" + fund_change +
        ", store_name=" + store_name +
        "}";
    }
}
