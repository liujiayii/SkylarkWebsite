package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 订单商品表
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-17
 */
public class T_shopping extends Model<T_shopping> {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠金额
     */
    private Integer youhuijine;

    /**
     * 商品订单
     */
    @TableId(value = "shoping_id", type = IdType.AUTO)
    private Integer shoping_id;

    /**
     * 商品id
     */
    private String product_id;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 商品编号
     */
    private String order_id;

    /**
     * 是否点评(1.未评论  2.已评论)
     */
    private String is_dianpng;

    /**
     * 商品单价
     */
    private Double danjia;

    /**
     * 单种商品的总价
     */
    private Double zongjia;
    /**
     * 商品状态
     */
    private String state;
    /**
     * 规格
     */
    private String shoping_specifications;
    /**
     * 物流编号
     * @return
     */
    private String shoping_logistics;
    
    public String getShoping_logistics() {
		return shoping_logistics;
	}

	public void setShoping_logistics(String shoping_logistics) {
		this.shoping_logistics = shoping_logistics;
	}

	public String getShoping_specifications() {
		return shoping_specifications;
	}

	public void setShoping_specifications(String shoping_specifications) {
		this.shoping_specifications = shoping_specifications;
	}

	public Integer getYouhuijine() {
        return youhuijine;
    }

    public void setYouhuijine(Integer youhuijine) {
        this.youhuijine = youhuijine;
    }
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
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.shoping_id;
    }

    @Override
	public String toString() {
		return "T_shopping [youhuijine=" + youhuijine + ", shoping_id=" + shoping_id + ", product_id=" + product_id
				+ ", number=" + number + ", order_id=" + order_id + ", is_dianpng=" + is_dianpng + ", danjia=" + danjia
				+ ", zongjia=" + zongjia + ", state=" + state + ", shoping_specifications=" + shoping_specifications
				+ ", shoping_logistics=" + shoping_logistics + "]";
	}
}
