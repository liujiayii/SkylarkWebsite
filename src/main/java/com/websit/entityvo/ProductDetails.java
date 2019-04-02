package com.websit.entityvo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductDetails implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * 主键id
     */
    private Long productId;

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
     * 商品一级分类id
     */
    private Long classificationIds;
    /**
     * 商品一级分类名称
     */
    private String classificationNames;
    /**
     * 商品一级分类id
     */
    private Long zoneIds;
    /**
     * 商品一级分类名称
     */
    private String zoneNames;
    
    /**
     * 商品所包含的图片集合
     */
    private List<ProductImage> productImage;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Long getClassificationIds() {
		return classificationIds;
	}

	public void setClassificationIds(Long classificationIds) {
		this.classificationIds = classificationIds;
	}

	public String getClassificationNames() {
		return classificationNames;
	}

	public void setClassificationNames(String classificationNames) {
		this.classificationNames = classificationNames;
	}

	public Long getZoneIds() {
		return zoneIds;
	}

	public void setZoneIds(Long zoneIds) {
		this.zoneIds = zoneIds;
	}

	public String getZoneNames() {
		return zoneNames;
	}

	public void setZoneNames(String zoneNames) {
		this.zoneNames = zoneNames;
	}

	public List<ProductImage> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**  
	
	* <p>Title: </p>  
	
	* <p>Description: </p>  
	  
	
	*/  
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDetails [productId=").append(productId).append(", productName=").append(productName)
				.append(", producttypeid=").append(producttypeid).append(", producttypename=").append(producttypename)
				.append(", image=").append(image).append(", price=").append(price).append(", color=").append(color)
				.append(", state=").append(state).append(", create_times=").append(create_times).append(", brand=")
				.append(brand).append(", specifications=").append(specifications).append(", describion=")
				.append(describion).append(", classificationIds=").append(classificationIds)
				.append(", classificationNames=").append(classificationNames).append(", zoneIds=").append(zoneIds)
				.append(", zoneNames=").append(zoneNames).append(", productImage=").append(productImage).append("]");
		return builder.toString();
	}
	
    
}
