package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品评论回复表（蔺）
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_revert extends Model<T_revert> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品评论回复表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论表id
     */
    private Long review_id;

    /**
     * 回复人id
     */
    private Long user_id;

    /**
     * 被回复人id
     */
    private Long byuser_id;

    /**
     * 回复内容
     */
    private String revert;

    /**
     * 回复时间
     */
    private Date revert_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public Long getByuser_id() {
        return byuser_id;
    }

    public void setByuser_id(Long byuser_id) {
        this.byuser_id = byuser_id;
    }
    public String getRevert() {
        return revert;
    }

    public void setRevert(String revert) {
        this.revert = revert;
    }
    public Date getRevert_time() {
        return revert_time;
    }

    public void setRevert_time(Date revert_time) {
        this.revert_time = revert_time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_revert{" +
        "id=" + id +
        ", review_id=" + review_id +
        ", user_id=" + user_id +
        ", byuser_id=" + byuser_id +
        ", revert=" + revert +
        ", revert_time=" + revert_time +
        "}";
    }
}
