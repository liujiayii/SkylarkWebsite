package com.websit.entityvo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.websit.entity.T_product;

public class ZoneVo  extends Model<ZoneVo>{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 商品专区id
     */
    private Long zoneId;

    /**
     * 专区名称
     */
    private String ZoneName;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 专区名称
     */
    private String image;
    /**
     * 每个专区下商品列表
     */
    List<T_product>productLists;
	public Long getZoneId() {
		return zoneId;
	}
	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneName() {
		return ZoneName;
	}
	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<T_product> getProductLists() {
		return productLists;
	}
	public void setProductLists(List<T_product> productLists) {
		this.productLists = productLists;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZoneVo [zoneId=").append(zoneId).append(", ZoneName=").append(ZoneName).append(", create_time=")
				.append(create_time).append(", image=").append(image).append(", productLists=").append(productLists)
				.append("]");
		return builder.toString();
	}
	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ZoneVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Serializable pkVal() {
		
		return this.zoneId;
	}

	
}
