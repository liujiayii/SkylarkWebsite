package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 公司动态表
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-02
 */
public class T_dynamic extends Model<T_dynamic> {

    private static final long serialVersionUID = 1L;

    /**
     * 动态表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 动态标题
     */
    private String dynamic_title;

    /**
     * 动态内容
     */
    private String dynamic_content;

    /**
     * 动态图
     */
    private String dynamic_image;

    /**
     * 动态发布时间
     */
    private Date dynamic_time;
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dynamic_content == null) ? 0 : dynamic_content.hashCode());
		result = prime * result + ((dynamic_image == null) ? 0 : dynamic_image.hashCode());
		result = prime * result + ((dynamic_time == null) ? 0 : dynamic_time.hashCode());
		result = prime * result + ((dynamic_title == null) ? 0 : dynamic_title.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T_dynamic other = (T_dynamic) obj;
		if (dynamic_content == null) {
			if (other.dynamic_content != null)
				return false;
		} else if (!dynamic_content.equals(other.dynamic_content))
			return false;
		if (dynamic_image == null) {
			if (other.dynamic_image != null)
				return false;
		} else if (!dynamic_image.equals(other.dynamic_image))
			return false;
		if (dynamic_time == null) {
			if (other.dynamic_time != null)
				return false;
		} else if (!dynamic_time.equals(other.dynamic_time))
			return false;
		if (dynamic_title == null) {
			if (other.dynamic_title != null)
				return false;
		} else if (!dynamic_title.equals(other.dynamic_title))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDynamic_title() {
        return dynamic_title;
    }

    public void setDynamic_title(String dynamic_title) {
        this.dynamic_title = dynamic_title;
    }
    public String getDynamic_content() {
        return dynamic_content;
    }

    public void setDynamic_content(String dynamic_content) {
        this.dynamic_content = dynamic_content;
    }
    public String getDynamic_image() {
        return dynamic_image;
    }

    public void setDynamic_image(String dynamic_image) {
        this.dynamic_image = dynamic_image;
    }
    public Date getDynamic_time() {
        return dynamic_time;
    }

    public void setDynamic_time(Date dynamic_time) {
        this.dynamic_time = dynamic_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public String toString() {
		return "T_dynamic [id=" + id + ", dynamic_title=" + dynamic_title + ", dynamic_content=" + dynamic_content
				+ ", dynamic_image=" + dynamic_image + ", dynamic_time=" + dynamic_time + "]";
	}

}
