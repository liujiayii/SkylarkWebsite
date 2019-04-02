package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-23
 */
public class T_goods extends Model<T_goods> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goods_id;

    /**
     * 姓名
     */
    private String goods_name;

    /**
     * 电话
     */
    private String goods_tel;

    /**
     * 省
     */
    private String goods_sheng;

    /**
     * 市
     */
    private String goods_shi;

    /**
     * 县区
     */
    private String goods_xian;

    /**
     * 详细地址
     */
    private String goods_address;

    /**
     * 状态
     */
    private String goods_ster;

    /**
     * 用户id
     */
    private Long user_id;

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }
    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
    public String getGoods_tel() {
        return goods_tel;
    }

    public void setGoods_tel(String goods_tel) {
        this.goods_tel = goods_tel;
    }
    public String getGoods_sheng() {
        return goods_sheng;
    }

    public void setGoods_sheng(String goods_sheng) {
        this.goods_sheng = goods_sheng;
    }
    public String getGoods_shi() {
        return goods_shi;
    }

    public void setGoods_shi(String goods_shi) {
        this.goods_shi = goods_shi;
    }
    public String getGoods_xian() {
        return goods_xian;
    }

    public void setGoods_xian(String goods_xian) {
        this.goods_xian = goods_xian;
    }
    public String getGoods_address() {
        return goods_address;
    }

    public void setGoods_address(String goods_address) {
        this.goods_address = goods_address;
    }
    public String getGoods_ster() {
        return goods_ster;
    }

    public void setGoods_ster(String goods_ster) {
        this.goods_ster = goods_ster;
    }
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.goods_id;
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "T_goods [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_tel=" + goods_tel
				+ ", goods_sheng=" + goods_sheng + ", goods_shi=" + goods_shi + ", goods_xian=" + goods_xian
				+ ", goods_address=" + goods_address + ", goods_ster=" + goods_ster + ", user_id=" + user_id + "]";
	}
    
}
