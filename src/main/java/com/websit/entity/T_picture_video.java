package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 图片视频表（蔺）
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_picture_video extends Model<T_picture_video> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片视频表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品表评论id
     */
    private Long review_id;

    /**
     * 图片路径
     */
    private String picture;

    /**
     * 视频路径
     */
    private String video;

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
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_picture_video{" +
        "id=" + id +
        ", review_id=" + review_id +
        ", picture=" + picture +
        ", video=" + video +
        "}";
    }
}
