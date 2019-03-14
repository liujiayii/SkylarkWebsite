package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 会员与访问数量表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_access extends Model<T_access> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员总数量
     */
    private Long Count;

    /**
     * 网站访问量
     */
    private Long number;

    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCount() {
        return Count;
    }

    public void setCount(Long Count) {
        this.Count = Count;
    }
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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
        return "T_access{" +
        "id=" + id +
        ", Count=" + Count +
        ", number=" + number +
        ", create_time=" + create_time +
        "}";
    }
}
