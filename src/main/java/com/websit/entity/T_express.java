package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 快递公司表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_express extends Model<T_express> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 快递公司名称
     */
    private String expName;

    /**
     * 快递公司短码
     */
    private String type;

    /**
     * 快递公司官方客服电话
     */
    private String expPhone;

    /**
     * 快递公司官网地址
     */
    private String expSite;

    /**
     * 请求的快递单号
     */
    private String number;

    /**
     * 运单的当前状态码
     */
    private Integer deliverystatus;
    
    /**
     * 快递员姓名
     */
    private String courier;
    
    /**
     * 快递员电话
     */
    private String courierPhone;
    
    /**
     * 是否签收
     */
    private Integer issign;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpPhone() {
		return expPhone;
	}

	public void setExpPhone(String expPhone) {
		this.expPhone = expPhone;
	}

	public String getExpSite() {
		return expSite;
	}

	public void setExpSite(String expSite) {
		this.expSite = expSite;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getDeliverystatus() {
		return deliverystatus;
	}

	public void setDeliverystatus(Integer deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCourierPhone() {
		return courierPhone;
	}

	public void setCourierPhone(String courierPhone) {
		this.courierPhone = courierPhone;
	}

	public Integer getIssign() {
		return issign;
	}

	public void setIssign(Integer issign) {
		this.issign = issign;
	}

	@Override
	public String toString() {
		return "T_express [id=" + id + ", expName=" + expName + ", type=" + type + ", expPhone=" + expPhone
				+ ", expSite=" + expSite + ", number=" + number + ", deliverystatus=" + deliverystatus + ", courier="
				+ courier + ", courierPhone=" + courierPhone + ", issign=" + issign + "]";
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
    

}
