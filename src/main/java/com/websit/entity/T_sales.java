package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 退货表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_sales extends Model<T_sales> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "sales_id", type = IdType.AUTO)
    private Integer sales_id;

    /**
     * 订单id
     */
    private String order_id;

    /**
     * 退货原因
     */
    private String sales_cause;

    /**
     * 退货类别
     */
    private String cause_type;

    /**
     * 退货说明
     */
    private String cause_explain;

    /**
     * 退货时间
     */
    private Date cause_time;
    /**
     * 退货状态
     */
    private String  stele;
    /**
     * 退货编号
     */
    private String sales_no;

    public String getSales_no() {
		return sales_no;
	}

	public void setSales_no(String sales_no) {
		this.sales_no = sales_no;
	}

	public String getStele() {
		return stele;
	}

	public void setStele(String stele) {
		this.stele = stele;
	}

	public Integer getSales_id() {
        return sales_id;
    }

    public void setSales_id(Integer sales_id) {
        this.sales_id = sales_id;
    }
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getSales_cause() {
        return sales_cause;
    }

    public void setSales_cause(String sales_cause) {
        this.sales_cause = sales_cause;
    }
    public String getCause_type() {
        return cause_type;
    }

    public void setCause_type(String cause_type) {
        this.cause_type = cause_type;
    }
    public String getCause_explain() {
        return cause_explain;
    }

    public void setCause_explain(String cause_explain) {
        this.cause_explain = cause_explain;
    }
    public Date getCause_time() {
        return cause_time;
    }

    public void setCause_time(Date cause_time) {
        this.cause_time = cause_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.sales_id;
    }

    @Override
	public String toString() {
		return "T_sales [sales_id=" + sales_id + ", order_id=" + order_id + ", sales_cause=" + sales_cause
				+ ", cause_type=" + cause_type + ", cause_explain=" + cause_explain + ", cause_time=" + cause_time
				+ ", stele=" + stele + ", sales_no=" + sales_no + "]";
	}
}
