package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品订单表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public class T_shopping extends Model<T_shopping> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品订单
     */
    @TableId(value = "shoping_id", type = IdType.AUTO)
    private Integer shoping_id;

    private String product_id;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 订单id
     */
    private String order_id;

    /**
     * 是否点评
     */
    private String is_dianpng;

    private Double danjia;

    /**
     * 0
     */
    private Double zongjia;
    /**
     * 优惠金额
     * @return
     */
    public int getYouhuijine() {
		return youhuijine;
	}

	public void setYouhuijine(int youhuijine) {
		this.youhuijine = youhuijine;
	}

	private int youhuijine;

    public Integer getShoping_id() {
        return shoping_id;
    }

    public void setShoping_id(Integer shoping_id) {
        this.shoping_id = shoping_id;
    }
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getIs_dianpng() {
        return is_dianpng;
    }

    public void setIs_dianpng(String is_dianpng) {
        this.is_dianpng = is_dianpng;
    }
    public Double getDanjia() {
        return danjia;
    }

    public void setDanjia(Double danjia) {
        this.danjia = danjia;
    }
    public Double getZongjia() {
        return zongjia;
    }

    public void setZongjia(Double zongjia) {
        this.zongjia = zongjia;
    }

    @Override
    protected Serializable pkVal() {
        return this.shoping_id;
    }

    @Override
	public String toString() {
		return "T_shopping [shoping_id=" + shoping_id + ", product_id=" + product_id + ", number=" + number
				+ ", order_id=" + order_id + ", is_dianpng=" + is_dianpng + ", danjia=" + danjia + ", zongjia="
				+ zongjia + ", youhuijine=" + youhuijine + "]";
	}
}
