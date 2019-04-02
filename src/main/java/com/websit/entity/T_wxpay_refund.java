package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 退款记录表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public class T_wxpay_refund extends Model<T_wxpay_refund> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微信退款单号
     */
    private String refund_id;

    /**
     * 退款金额
     */
    private String refund_fee;

    /**
     * 返回信息
     */
    private String return_msg;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 微信订单号
     */
    private String transaction_id;

    /**
     * 商户退款单号
     */
    private String out_refund_no;

    private String result_code;

    /**
     * 订单金额
     */
    private Integer total_fee;

    /**
     * 返回状态码
     */
    private String return_code;

    /**
     * 退款通道
     */
    private String refund_channel;

    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }
    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }
    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }
    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }
    public String getRefund_channel() {
        return refund_channel;
    }

    public void setRefund_channel(String refund_channel) {
        this.refund_channel = refund_channel;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_wxpay_refund{" +
        "id=" + id +
        ", refund_id=" + refund_id +
        ", refund_fee=" + refund_fee +
        ", return_msg=" + return_msg +
        ", out_trade_no=" + out_trade_no +
        ", transaction_id=" + transaction_id +
        ", out_refund_no=" + out_refund_no +
        ", result_code=" + result_code +
        ", total_fee=" + total_fee +
        ", return_code=" + return_code +
        ", refund_channel=" + refund_channel +
        ", time=" + time +
        "}";
    }
}
