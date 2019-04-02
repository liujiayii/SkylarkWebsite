package com.websit.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class Zone extends Model<Zone> {

	  /**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专区名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 专区图标
     */
    private String image;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zone [id=").append(id).append(", name=").append(name).append(", create_time=")
				.append(create_time).append(", image=").append(image).append("]");
		return builder.toString();
	}

}
