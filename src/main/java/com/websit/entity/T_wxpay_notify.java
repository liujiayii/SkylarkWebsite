package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 微信支付回调表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public class T_wxpay_notify extends Model<T_wxpay_notify> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * user表id
     */
    private Integer user_id;

    /**
     * 支付人的openid
     */
    private String openid;

    /**
     * 支付金额  单位 分
     */
    private String cash_fee;

    /**
     * 订单总金额  单位 分
     */
    private String total_fee;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 微信订单号
     */
    private String transaction_id;

    /**
     * 业务结果  SUCCESS/FAIL   SUCCESS退款申请接收成功，结果通过退款查询接口查询     FAIL 提交业务失败
     */
    private String result_code;

    /**
     * 返回状态码   SUCCESS  请求成功/FAIL 请求失败
     */
    private String return_code;

    /**
     * 插入时间
     */
    private Date time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }
    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
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
    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
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
        return "T_wxpay_notify{" +
        "id=" + id +
        ", user_id=" + user_id +
        ", openid=" + openid +
        ", cash_fee=" + cash_fee +
        ", total_fee=" + total_fee +
        ", out_trade_no=" + out_trade_no +
        ", transaction_id=" + transaction_id +
        ", result_code=" + result_code +
        ", return_code=" + return_code +
        ", time=" + time +
        "}";
    }
}
