package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Transient;

/**
 * <p>
 * 板块表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_plate extends Model<T_plate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司id
     */
    private Long company_id;

    /**
     * 板块介绍
     */
    private String introduce;

    /**
     * 板块图标
     */
    private String image;

    /**
     * 这个板块今日贴子总数
     */
    private Long number;

    /**
     * 这个板块的总贴子数
     */
    private Long numbers;

    /**
     * 版主
     */
    private String name;
    
    /**
     * 版块名称
     */
    private String plate_name;
    
    /**
     * 版块下总回帖量（临时属性）
     */
    @Transient
    private Integer commentCount = 0;
    
    /**
     * 标签表集合（临时属性）
     */
    private List<T_tag> tagList;
    
    public List<T_tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<T_tag> tagList) {
		this.tagList = tagList;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getPlate_name() {
		return plate_name;
	}

	public void setPlate_name(String plate_name) {
		this.plate_name = plate_name;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public String toString() {
		return "T_plate [id=" + id + ", company_id=" + company_id + ", introduce=" + introduce + ", image=" + image
				+ ", number=" + number + ", numbers=" + numbers + ", name=" + name + ", plate_name=" + plate_name + "]";
	}

    
}
