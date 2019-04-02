package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 支付成功的记录
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-27
 */
public class T_alipay_success extends Model<T_alipay_success> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 支付宝单号
     */
    private String trade_no;

    /**
     * 商家单号
     */
    private String out_trade_no;

    /**
     * 订单金额
     */
    private BigDecimal total_amount;

    /**
     * 付款时间
     */
    private Date pay_date;

    /**
     * 收款支付宝id
     */
    private Long seller_id;

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
    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }
    public Long getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Long seller_id) {
        this.seller_id = seller_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_alipay_success{" +
        "id=" + id +
        ", trade_no=" + trade_no +
        ", out_trade_no=" + out_trade_no +
        ", total_amount=" + total_amount +
        ", pay_date=" + pay_date +
        ", seller_id=" + seller_id +
        "}";
    }
}
