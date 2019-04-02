package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 轮播图管理表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-30
 */
public class T_carousel extends Model<T_carousel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片地址
     */
    private String path;

    /**
     * 图片顺序
     */
    private Integer sequence;

    /**
     * 图片属于哪个模块
     */
    private Integer belong_to;

    /**
     * 添加时间
     */
    private Date creat_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    public Integer getBelong_to() {
        return belong_to;
    }

    public void setBelong_to(Integer belong_to) {
        this.belong_to = belong_to;
    }
    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_carousel{" +
        "id=" + id +
        ", path=" + path +
        ", sequence=" + sequence +
        ", belong_to=" + belong_to +
        ", creat_time=" + creat_time +
        "}";
    }
}
