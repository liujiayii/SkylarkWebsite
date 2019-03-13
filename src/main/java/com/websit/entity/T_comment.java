package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
public class T_comment extends Model<T_comment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论图片id
     */
    private Long image_id;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 帖子id
     */
    private Long posting_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Long getPosting_id() {
        return posting_id;
    }

    public void setPosting_id(Long posting_id) {
        this.posting_id = posting_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_comment{" +
        "id=" + id +
        ", comment=" + comment +
        ", image_id=" + image_id +
        ", create_time=" + create_time +
        ", posting_id=" + posting_id +
        "}";
    }
}
