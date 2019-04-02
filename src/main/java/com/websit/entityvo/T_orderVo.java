 /**
  *
  * @Title: T_orderVo.java
* @Package com.websit.entityvo
  * @Description: TODO(用一句话描述该文件做什么)
  *
* @author admin
* @date 2019年3月24日
*/
package com.websit.entityvo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @ClassName: T_orderVo
 * @description 用一句话描述这个类的作用
 *
 * @author 姓名全拼
 * @createDate 2019年3月24日
 */
public class T_orderVo implements Serializable{
	/**  字段的含义 */
	private static final long serialVersionUID = 1L;
	/**
     * 订单金额
     */
    private Double order_money;
   /**
    * 订单编号
    */
    private String order_no;

    /**
     * 状态
     */
    private String order_state;
    /**
     * 商品id
     */
    private String product_id;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 订单id
     */
    private String order_id;

    /**
     * 是否点评
     */
    private String is_dianpng;
    /**
     * 商品名称
     */
    private String name;

    /**
     * 图片
     */
    private String image;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 颜色
     */
    private String color;

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
    private String describe;
    
    /**
     *一种商品的价格 
     */
    private BigDecimal money;
    /**
     * 用户id
     */
    private String user_id;
    
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Double getOrder_money() {
		return order_money;
	}

	public void setOrder_money(Double order_money) {
		this.order_money = order_money;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getIs_dianpng() {
		return is_dianpng;
	}

	public void setIs_dianpng(String is_dianpng) {
		this.is_dianpng = is_dianpng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((is_dianpng == null) ? 0 : is_dianpng.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((order_money == null) ? 0 : order_money.hashCode());
		result = prime * result + ((order_no == null) ? 0 : order_no.hashCode());
		result = prime * result + ((order_state == null) ? 0 : order_state.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((specifications == null) ? 0 : specifications.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T_orderVo other = (T_orderVo) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (is_dianpng == null) {
			if (other.is_dianpng != null)
				return false;
		} else if (!is_dianpng.equals(other.is_dianpng))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (order_money == null) {
			if (other.order_money != null)
				return false;
		} else if (!order_money.equals(other.order_money))
			return false;
		if (order_no == null) {
			if (other.order_no != null)
				return false;
		} else if (!order_no.equals(other.order_no))
			return false;
		if (order_state == null) {
			if (other.order_state != null)
				return false;
		} else if (!order_state.equals(other.order_state))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (specifications == null) {
			if (other.specifications != null)
				return false;
		} else if (!specifications.equals(other.specifications))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "T_orderVo [order_money=" + order_money + ", order_no=" + order_no + ", order_state=" + order_state
				+ ", product_id=" + product_id + ", number=" + number + ", order_id=" + order_id + ", is_dianpng="
				+ is_dianpng + ", name=" + name + ", image=" + image + ", price=" + price + ", color=" + color
				+ ", brand=" + brand + ", specifications=" + specifications + ", describe=" + describe + ", money="
				+ money + ", user_id=" + user_id + "]";
	}
    
}
