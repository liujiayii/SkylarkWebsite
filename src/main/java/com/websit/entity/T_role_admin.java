package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
public class T_role_admin extends Model<T_role_admin> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long admin_id;

    /**
     * 角色id
     */
    private Long role_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public T_role_admin() {
		super();
	}

	public T_role_admin(Long id, Long admin_id, Long role_id) {
		super();
		this.id = id;
		this.admin_id = admin_id;
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "T_admin_role [id=" + id + ", admin_id=" + admin_id + ", role_id=" + role_id + "]";
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
    
}
