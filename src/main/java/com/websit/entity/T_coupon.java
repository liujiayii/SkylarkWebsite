package com.websit.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 优惠券实体表
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-19
 */
public class T_coupon extends Model<T_coupon> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片（base64）
     */
    private String icon;

    /**
     * 优惠券标题 （无门槛30元优惠，饮水机直减50元）
     */
    private String title;

    /**
     * 适用范围 （10 商品优惠券，20 类目优惠券，30全平台）
     */
    private Integer used;

    /**
     *  优惠类型（1 满减，2 打折，3 无门槛）
     */
    private Integer type;

    /**
     * 是否可以用于特价商品（1 可以，2 不可以）
     */
    private Integer with_special;

    /**
     * 商品号或分类号
     */
    private Long with_sn;

    /**
     * 使用条件（满多少可以使用 比如 满200可以使用）
     */
    private BigDecimal with_amount;

    /**
     * 优惠券金额（满减和无门槛需的值要是优惠的金额 如 30，打折券需要这块率如0.9）
     */
    private Double used_amount;

    /**
     * 优惠券的数量（比如这种优惠券只发放100张 就是100）
     */
    private Integer quota;

    /**
     * 已经领取的优惠券数量
     */
    private Integer take_count;

    /**
     * 已经使用的优惠券数量
     */
    private Integer used_coun;

    /**
     * 发放开始时间
     */
    private Date start_time;

    /**
     * 发放结束时间
     */
    private Date end_time;

    /**
     * 有效时间（1 绝对有效时间，2相对有效时间）
     */
    private Integer valid_type;

    /**
     * 使用开始时间
     */
    private Date valid_start_time;

    /**
     * 使用结束时间
     */
    private Date valid_end_time;

    /**
     * 自领取之日起有效天数
     */
    private Integer valid_days;

    /**
     * 1 生效 2失效 3已结束
     */
    private Integer status;

    /**
     * 创建者id
     */
    private Long create_user;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 修改者id
     */
    private Long update_user;

    /**
     * 修改时间
     */
    private Date update_time;

    /**
     * 领取限制（0每人可无限制领取，1每人限领一次，2每人限领2次以此类推........）
     */
    private Integer get_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getWith_special() {
        return with_special;
    }

    public void setWith_special(Integer with_special) {
        this.with_special = with_special;
    }
    public Long getWith_sn() {
        return with_sn;
    }

    public void setWith_sn(Long with_sn) {
        this.with_sn = with_sn;
    }
    public BigDecimal getWith_amount() {
        return with_amount;
    }

    public void setWith_amount(BigDecimal with_amount) {
        this.with_amount = with_amount;
    }
    public Double getUsed_amount() {
        return used_amount;
    }

    public void setUsed_amount(Double used_amount) {
        this.used_amount = used_amount;
    }
    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }
    public Integer getTake_count() {
        return take_count;
    }

    public void setTake_count(Integer take_count) {
        this.take_count = take_count;
    }
    public Integer getUsed_coun() {
        return used_coun;
    }

    public void setUsed_coun(Integer used_coun) {
        this.used_coun = used_coun;
    }
    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
    public Integer getValid_type() {
        return valid_type;
    }

    public void setValid_type(Integer valid_type) {
        this.valid_type = valid_type;
    }
    public Date getValid_start_time() {
        return valid_start_time;
    }

    public void setValid_start_time(Date valid_start_time) {
        this.valid_start_time = valid_start_time;
    }
    public Date getValid_end_time() {
        return valid_end_time;
    }

    public void setValid_end_time(Date valid_end_time) {
        this.valid_end_time = valid_end_time;
    }
    public Integer getValid_days() {
        return valid_days;
    }

    public void setValid_days(Integer valid_days) {
        this.valid_days = valid_days;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getCreate_user() {
        return create_user;
    }

    public void setCreate_user(Long create_user) {
        this.create_user = create_user;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Long getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(Long update_user) {
        this.update_user = update_user;
    }
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public Integer getGet_number() {
        return get_number;
    }

    public void setGet_number(Integer get_number) {
        this.get_number = get_number;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "T_coupon{" +
        "id=" + id +
        ", icon=" + icon +
        ", title=" + title +
        ", used=" + used +
        ", type=" + type +
        ", with_special=" + with_special +
        ", with_sn=" + with_sn +
        ", with_amount=" + with_amount +
        ", used_amount=" + used_amount +
        ", quota=" + quota +
        ", take_count=" + take_count +
        ", used_coun=" + used_coun +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", valid_type=" + valid_type +
        ", valid_start_time=" + valid_start_time +
        ", valid_end_time=" + valid_end_time +
        ", valid_days=" + valid_days +
        ", status=" + status +
        ", create_user=" + create_user +
        ", create_time=" + create_time +
        ", update_user=" + update_user +
        ", update_time=" + update_time +
        ", get_number=" + get_number +
        "}";
    }
}
