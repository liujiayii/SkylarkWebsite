package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 支付宝退款记录表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-27
 */
public class T_alipay_refund extends Model<T_alipay_refund> {

    private static final long serialVersionUID = 1L;

    /**
     * 支付宝退款表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 买家在支付宝的用户id
     */
    private String buyer_user_id;

    /**
     * 本次退款是否发生了资金变化
     */
    private String fund_change;

    /**
     * 退款支付时间
     */
    private Date gmt_refund_pay;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 本次退款金额中买家退款金额
     */
    private String present_refund_buyer_amount;

    /**
     * 退款总金额
     */
    private BigDecimal refund_fee;

    /**
     * 交易在支付时候的门店名称
     */
    private String store_name;

    /**
     * 本次商户实际退回金额；
     */
    private String send_back_fee;

    /**
     * 本次退款金额中平台优惠退款金额
     */
    private String present_refund_discount_amount;

    /**
     * 本次退款金额中商家优惠退款金额
     */
    private String present_refund_mdiscount_amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }
    public String getFund_change() {
        return fund_change;
    }

    public void setFund_change(String fund_change) {
        this.fund_change = fund_change;
    }
    public Date getGmt_refund_pay() {
        return gmt_refund_pay;
    }

    public void setGmt_refund_pay(Date gmt_refund_pay) {
        this.gmt_refund_pay = gmt_refund_pay;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getPresent_refund_buyer_amount() {
        return present_refund_buyer_amount;
    }

    public void setPresent_refund_buyer_amount(String present_refund_buyer_amount) {
        this.present_refund_buyer_amount = present_refund_buyer_amount;
    }
    public BigDecimal getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(BigDecimal refund_fee) {
        this.refund_fee = refund_fee;
    }
    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
    public String getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(String send_back_fee) {
        this.send_back_fee = send_back_fee;
    }
    public String getPresent_refund_discount_amount() {
        return present_refund_discount_amount;
    }

    public void setPresent_refund_discount_amount(String present_refund_discount_amount) {
        this.present_refund_discount_amount = present_refund_discount_amount;
    }
    public String getPresent_refund_mdiscount_amount() {
        return present_refund_mdiscount_amount;
    }

    public void setPresent_refund_mdiscount_amount(String present_refund_mdiscount_amount) {
        this.present_refund_mdiscount_amount = present_refund_mdiscount_amount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_alipay_refund{" +
        "id=" + id +
        ", buyer_user_id=" + buyer_user_id +
        ", fund_change=" + fund_change +
        ", gmt_refund_pay=" + gmt_refund_pay +
        ", out_trade_no=" + out_trade_no +
        ", present_refund_buyer_amount=" + present_refund_buyer_amount +
        ", refund_fee=" + refund_fee +
        ", store_name=" + store_name +
        ", send_back_fee=" + send_back_fee +
        ", present_refund_discount_amount=" + present_refund_discount_amount +
        ", present_refund_mdiscount_amount=" + present_refund_mdiscount_amount +
        "}";
    }
}
