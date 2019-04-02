package com.websit.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 运费表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-25
 */
public class T_freight extends Model<T_freight> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 最高金额
     */
    private BigDecimal price;

    /**
     * 最低金额
     */
    private BigDecimal prices;

    /**
     * 运费
     */
    private BigDecimal freight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }
    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_freight{" +
        "id=" + id +
        ", price=" + price +
        ", prices=" + prices +
        ", freight=" + freight +
        "}";
    }
}
