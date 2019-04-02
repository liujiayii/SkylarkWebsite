package com.websit.entityvo;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.websit.entity.Classification;

public class ProductVo extends Model<ProductVo>{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	 /**
     * 主键id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品类型id
     */
    private Long producttypeid;
    /**
     * 商品类型名称
     */
    private String producttypename;
    /**
     * 图片
     */
    private String image;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 颜色
     */
    private String color;

    /**
     * 状态(1:上架,2:下架)
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date create_times;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 商品描述
     */
    private String describion;
    /**
     * 商品专区id
     */
    private Long zoneid;
    /**
     * 商品专区名称
     */
    private String zonename;
    /** 页数 */
 		private int page;
 		/** 分页条数 */
 		private int limit;
 		/** 数据条数 */
 		private Integer count;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public Long getProducttypeid() {
			return producttypeid;
		}
		public void setProducttypeid(Long producttypeid) {
			this.producttypeid = producttypeid;
		}
		public String getProducttypename() {
			return producttypename;
		}
		public void setProducttypename(String producttypename) {
			this.producttypename = producttypename;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public Integer getState() {
			return state;
		}
		public void setState(Integer state) {
			this.state = state;
		}
		public Date getCreate_times() {
			return create_times;
		}
		public void setCreate_times(Date create_times) {
			this.create_times = create_times;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getSpecifications() {
			return specifications;
		}
		public void setSpecifications(String specifications) {
			this.specifications = specifications;
		}
		public String getDescribion() {
			return describion;
		}
		public void setDescribion(String describion) {
			this.describion = describion;
		}
		public Long getZoneid() {
			return zoneid;
		}
		public void setZoneid(Long zoneid) {
			this.zoneid = zoneid;
		}
		public String getZonename() {
			return zonename;
		}
		public void setZonename(String zonename) {
			this.zonename = zonename;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getLimit() {
			return limit;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		/**  
		
		* <p>Title: </p>  
		
		* <p>Description: </p>  
		  
		
		*/  
		public ProductVo() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ProductVo [id=").append(id).append(", productName=").append(productName)
					.append(", producttypeid=").append(producttypeid).append(", producttypename=")
					.append(producttypename).append(", image=").append(image).append(", price=").append(price)
					.append(", color=").append(color).append(", state=").append(state).append(", create_times=")
					.append(create_times).append(", brand=").append(brand).append(", specifications=")
					.append(specifications).append(", describion=").append(describion).append(", zoneid=")
					.append(zoneid).append(", zonename=").append(zonename).append(", page=").append(page)
					.append(", limit=").append(limit).append(", count=").append(count).append("]");
			return builder.toString();
		}
		@Override
		protected Serializable pkVal() {
		
			return this.id;
		}

	
}
