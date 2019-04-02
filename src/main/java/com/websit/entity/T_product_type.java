package com.websit.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 商品类型表
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-21
 */
public class T_product_type extends Model<T_product_type> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 类型图标
     */
    private String ioc;
    /**
     * 商品一级分类id
     */
    private Long classificationId;
    /**
     * 商品一级分类名称
     */
    private String classificationName;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getIoc() {
		return ioc;
	}
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
	public Long getClassificationId() {
		return classificationId;
	}
	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}
	public String getClassificationName() {
		return classificationName;
	}
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public T_product_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T_product_type [id=").append(id).append(", name=").append(name).append(", create_time=")
				.append(create_time).append(", ioc=").append(ioc).append(", classificationId=").append(classificationId)
				.append(", classificationName=").append(classificationName).append("]");
		return builder.toString();
	}
	@Override
	protected Serializable pkVal() {
		
		return this.id;
	}
	
}
