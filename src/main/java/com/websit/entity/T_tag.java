package com.websit.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class T_tag extends Model<T_tag> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		return null;
	}
	/** 主键 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/** 标签名称 */
	private String tag_name;
	/** 帖子表id */
	private Long posting_id;
	/** 版块表id */
	private Long plate_id;
	/** 公司表id */
	private Long company_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public Long getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(Long posting_id) {
		this.posting_id = posting_id;
	}
	public Long getPlate_id() {
		return plate_id;
	}
	public void setPlate_id(Long plate_id) {
		this.plate_id = plate_id;
	}
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	
	public T_tag() {
		super();
	}
	
	public T_tag(String tag_name, Long posting_id, Long plate_id, Long company_id) {
		super();
		this.tag_name = tag_name;
		this.posting_id = posting_id;
		this.plate_id = plate_id;
		this.company_id = company_id;
	}
	
	@Override
	public String toString() {
		return "T_tag [id=" + id + ", tag_name=" + tag_name + ", posting_id=" + posting_id + ", plate_id=" + plate_id
				+ ", company_id=" + company_id + "]";
	}
	
	
}
