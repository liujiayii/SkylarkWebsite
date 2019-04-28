package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品详情表(pc)
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-20
 */
public class T_product_specification extends Model<T_product_specification> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long product_id;

    /**
     * 商品规格选项表数组
     */
    private String specificationName;

    /**
     * 成本价
     */
    private BigDecimal cost_price;

    /**
     * 折扣价
     */
    private BigDecimal discount_price;

    /**
     * 销售价
     */
    private BigDecimal price;

    /**
     * 商品规格选项表id
     */
    private Long t_spectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }
    public BigDecimal getCost_price() {
        return cost_price;
    }

    public void setCost_price(BigDecimal cost_price) {
        this.cost_price = cost_price;
    }
    public BigDecimal getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(BigDecimal discount_price) {
        this.discount_price = discount_price;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Long getT_spectId() {
        return t_spectId;
    }

    public void setT_spectId(Long t_spectId) {
        this.t_spectId = t_spectId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_product_specification{" +
        "id=" + id +
        ", product_id=" + product_id +
        ", specificationName=" + specificationName +
        ", cost_price=" + cost_price +
        ", discount_price=" + discount_price +
        ", price=" + price +
        ", t_spectId=" + t_spectId +
        "}";
    }
}
