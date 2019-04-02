package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 微信统一下单表（预支付）
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public class T_wxpay_unified_order extends Model<T_wxpay_unified_order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * user表id
     */
    private String user_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 终端IP(客户手机ip)
     */
    private String spbill_create_ip;

    /**
     * 订单总金额  单位 分
     */
    private String total_fee;

    /**
     * 业务支付结果  SUCCESS/FAIL   
     */
    private String result_code;

    /**
     * 返回状态码   SUCCESS  请求成功/FAIL 请求失败
     */
    private String return_code;

    /**
     * 返回信息
     */
    private String return_msg;

    /**
     * 错误代码
     */
    private String err_code;

    /**
     * 错误信息描述
     */
    private String err_code_des;

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
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }
    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
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
    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }
    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
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
        return "T_wxpay_unified_order{" +
        "id=" + id +
        ", user_id=" + user_id +
        ", out_trade_no=" + out_trade_no +
        ", spbill_create_ip=" + spbill_create_ip +
        ", total_fee=" + total_fee +
        ", result_code=" + result_code +
        ", return_code=" + return_code +
        ", return_msg=" + return_msg +
        ", err_code=" + err_code +
        ", err_code_des=" + err_code_des +
        ", time=" + time +
        "}";
    }
}
