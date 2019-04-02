package com.websit.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 支付成功的记录
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-26
 */
public class T_pay_success extends Model<T_pay_success> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商家单号
     */
    private String trade_no;

    /**
     * 支付宝单号
     */
    private String out_trade_no;

    /**
     * 账单支付金额
     */
    private BigDecimal total_amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_pay_success{" +
        "id=" + id +
        ", trade_no=" + trade_no +
        ", out_trade_no=" + out_trade_no +
        ", total_amount=" + total_amount +
        "}";
    }
}
