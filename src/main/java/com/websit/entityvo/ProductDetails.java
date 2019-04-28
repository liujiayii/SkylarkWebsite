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
     * 商品成本价
     */
    public BigDecimal cost_price;
    /**
     * 商品折扣价
     */
    public BigDecimal discount_price;

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
     * 商品专区id
     */
    private Long zoneid;
    /**
     * 商品专区名称
     */
    private String zoneNames;
    /**
     * 售后信息
     */
    private String after_information;
    /**
     * 商品所包含的图片集合
     */
    private List<ProductImage> productImage;
    /**
     * 商品所属类型下的规格及规格选项
     */
  //  private List<SpecificationsVo> specificationsVoList;
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
	public BigDecimal getCost_price() {
		return cost_price;
	}
	public void setCost_price(BigDecimal cost_price) {
		this.cost_price = cost_price;
	}
	public BigDecimal getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(BigDecimal discount_price) {
		this.discount_price = discount_price;
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
	public Long getZoneid() {
		return zoneid;
	}
	public void setZoneid(Long zoneid) {
		this.zoneid = zoneid;
	}
	public String getZoneNames() {
		return zoneNames;
	}
	public void setZoneNames(String zoneNames) {
		this.zoneNames = zoneNames;
	}
	public String getAfter_information() {
		return after_information;
	}
	public void setAfter_information(String after_information) {
		this.after_information = after_information;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDetails [productId=").append(productId).append(", productName=").append(productName)
				.append(", producttypeid=").append(producttypeid).append(", producttypename=").append(producttypename)
				.append(", image=").append(image).append(", price=").append(price).append(", cost_price=")
				.append(cost_price).append(", discount_price=").append(discount_price).append(", state=").append(state)
				.append(", create_times=").append(create_times).append(", brand=").append(brand).append(", describion=")
				.append(describion).append(", classificationIds=").append(classificationIds)
				.append(", classificationNames=").append(classificationNames).append(", zoneid=").append(zoneid)
				.append(", zoneNames=").append(zoneNames).append(", after_information=").append(after_information)
				.append(", productImage=").append(productImage).append("]");
		return builder.toString();
	}
	
}
