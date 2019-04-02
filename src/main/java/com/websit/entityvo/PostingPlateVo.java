package com.websit.entityvo;

import org.springframework.data.annotation.Transient;

import com.websit.entity.T_plate;
import com.websit.entity.T_posting;

public class PostingPlateVo extends T_posting {

	private static final long serialVersionUID = 1L;
	
	/** 模块  */
	private T_plate t_plate;
	
	/** 评论总条数  */
	@Transient
	private Integer commentCount = 0;

	public T_plate getT_plate() {
		return t_plate;
	}

	public void setT_plate(T_plate t_plate) {
		this.t_plate = t_plate;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "PostingPlateVo [t_plate=" + t_plate + ", commentCount=" + commentCount + "]";
	}

	
	
	 
	
}
