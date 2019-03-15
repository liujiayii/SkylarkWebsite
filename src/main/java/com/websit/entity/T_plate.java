package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 板块表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_plate extends Model<T_plate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司id
     */
    private Long company_id;

    /**
     * 板块介绍
     */
    private String introduce;

    /**
     * 板块图标
     */
    private String image;

    /**
     * 这个板块今日贴子总数
     */
    private Long number;

    /**
     * 这个板块的总贴子数
     */
    private Long numbers;

    /**
     * 版主
     */
    private String name;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_plate{" +
        "id=" + id +
        ", company_id=" + company_id +
        ", introduce=" + introduce +
        ", image=" + image +
        ", number=" + number +
        ", numbers=" + numbers +
        ", name=" + name +
        "}";
    }
}
