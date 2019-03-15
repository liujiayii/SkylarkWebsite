package com.websit.entityvo;
/**
 * 贴吧详情的标题的实体类
 * @author xxx
 *
 */
public class T_plateputing {
    /**
     * 公司id
     */
    private Long company_id;

    /**
     * 板块介绍
     */
    private String introduce;

    /**
     * 板块图标
     */
    private String image;

    /**
     * 这个板块今日贴子总数
     */
    private Long number;

    /**
     * 这个板块的总贴子数
     */
    private Long numbers;

    /**
     * 版主
     */
    private String name;
    /**
     * 标题
     */
    private String title;
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getNumbers() {
		return numbers;
	}
	public void setNumbers(Long numbers) {
		this.numbers = numbers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "T_plateputing [company_id=" + company_id + ", introduce=" + introduce + ", image=" + image + ", number="
				+ number + ", numbers=" + numbers + ", name=" + name + ", title=" + title + "]";
	}
    
}
