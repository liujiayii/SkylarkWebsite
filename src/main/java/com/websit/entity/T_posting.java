package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 发帖表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_posting extends Model<T_posting> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long user_id;

    /**
     * 内容
     */
    private String context;

    /**
     * 标题
     */
    private String title;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 板块id
     */
    private Long plate_id;
    
    /**
     * 是否精华帖（0.否，1.是）
     */
    private Integer is_good;
    
    /**
     * 设置精华帖时间
     */
    private Date toGood_time;
    /**
     * 访问次数
     */
    private int number;
    /*/*
     * 最新回复时间
     */
    private Date new_time;
    /*/*
     * 是否置顶
     */
    private int is_top;
    /*/*
     * 是否置顶
     */
    private int is_dele;
    

    public int getIs_dele() {
		return is_dele;
	}

	public void setIs_dele(int is_dele) {
		this.is_dele = is_dele;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getNew_time() {
		return new_time;
	}

	public void setNew_time(Date new_time) {
		this.new_time = new_time;
	}

	public int getIs_top() {
		return is_top;
	}

	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Long getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(Long plate_id) {
        this.plate_id = plate_id;
    }

    public Integer getIs_good() {
		return is_good;
	}

	public void setIs_good(Integer is_good) {
		this.is_good = is_good;
	}

	public Date getToGood_time() {
		return toGood_time;
	}

	public void setToGood_time(Date toGood_time) {
		this.toGood_time = toGood_time;
	}

	@Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public String toString() {
		return "T_posting [id=" + id + ", user_id=" + user_id + ", context=" + context + ", title=" + title
				+ ", introduce=" + introduce + ", create_time=" + create_time + ", plate_id=" + plate_id + ", is_good="
				+ is_good + ", toGood_time=" + toGood_time + ", number=" + number + ", new_time=" + new_time
				+ ", is_top=" + is_top + ", is_dele=" + is_dele + "]";
	}

	
	
}
