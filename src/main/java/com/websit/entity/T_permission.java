package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.Transient;

/**
 * <p>
 * 
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
public class T_permission extends Model<T_permission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 地址
     */
    private String url;

    /**
     * 父id
     */
    private Long pid;
    
    /**
     * 权限标识
     */
    private String perms;
    
    /**
     * 排序
     */
    private Integer order_num;
    
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menu_type;
    
    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Integer visible;
    
    /**
     * 图标
     */
    private String icon;
    
    /**
     * 前端组件component
     */
    private String component;
    
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	@Override
	public String toString() {
		return "T_permission [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url + ", pid="
				+ pid + ", perms=" + perms + ", order_num=" + order_num + ", menu_type=" + menu_type + ", visible="
				+ visible + ", icon=" + icon + ", component=" + component + "]";
	}

	
}
