package com.websit.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品规格表(pc)
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-24
 */
public class T_specifications extends Model<T_specifications> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规格名称
     */
    private String name;

    /**
     * 商品类型id
     */
    private Long product_type_id;

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
    public Long getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(Long product_type_id) {
        this.product_type_id = product_type_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_specifications{" +
        "id=" + id +
        ", name=" + name +
        ", product_type_id=" + product_type_id +
        "}";
    }
}
