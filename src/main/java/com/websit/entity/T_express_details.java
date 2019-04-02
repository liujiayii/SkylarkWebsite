package com.websit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 快递详情表
 *
 * @ClassName: T_express_details

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月21日-下午3:00:17
 */
public class T_express_details extends Model<T_express_details> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
    private Long id;
	
	/** 快递单号 */
	private String number;
	
	/** 时间点 */
	private String time;
	
	/** 详情 */
	private String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		
		return this.id;
	}

	@Override
	public String toString() {
		return "T_express_details [id=" + id + ", number=" + number + ", time=" + time + ", status=" + status + "]";
	}

	
}
