package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.websit.entity.T_role;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-24
 */
public class T_admin extends Model<T_admin> implements UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 账号（6到12位）
     */
    private String username;

    /**
     * 密码(6到12位)
     */
    private String password;

    /**
     * 职位
     */
    private String post;

    /**
     * 状态（0正常 1锁定 默认是0）
     */
    private Integer status;

    /**
     * 时间
     */
    private Date create_time;

    /**
     * 角色对象
     */
    private List<T_role> roles;

    public List<T_role> getRoles() {
		return roles;
	}

	public void setRoles(List<T_role> roles) {
		this.roles = roles;
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
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public String toString() {
		return "T_admin [id=" + id + ", name=" + name + ", phone=" + phone + ", username=" + username + ", password="
				+ password + ", post=" + post + ", status=" + status + ", create_time=" + create_time + ", roles="
				+ roles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	// 账号是否锁定
	@Override
	public boolean isAccountNonLocked() {
		
		return this.getStatus() == 0 ? true : false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

    
}
