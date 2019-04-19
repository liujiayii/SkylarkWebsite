package com.websit.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * app版本控制
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-15
 */
public class T_app extends Model<T_app> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "app_id", type = IdType.AUTO)
    private Integer app_id;

    /**
     * 版本
     */
    private String app_version;

    /**
     * 路径
     */
    private String app_url;

    /**
     * 是否强制更新
     */
    private String app_cood;

    /**
     * 名字
     */
    private String app_name;

    /**
     * 安装包类型  0是安卓，1是苹果
     */
    private String app_type;

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }
    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }
    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }
    public String getApp_cood() {
        return app_cood;
    }

    public void setApp_cood(String app_cood) {
        this.app_cood = app_cood;
    }
    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }
    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    @Override
    protected Serializable pkVal() {
        return this.app_id;
    }

    @Override
    public String toString() {
        return "T_app{" +
        "app_id=" + app_id +
        ", app_version=" + app_version +
        ", app_url=" + app_url +
        ", app_cood=" + app_cood +
        ", app_name=" + app_name +
        ", app_type=" + app_type +
        "}";
    }
}
