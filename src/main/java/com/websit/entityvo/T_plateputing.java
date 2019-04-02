package com.websit.entityvo;

import java.util.Date;
import java.util.List;

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
    /**
     * 内容
     */
    private String context;
    /**
     * 用户id
     */
    private  String id ;
    /**
     * 用户id
     */
    private  String user_id ;
    

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 发帖时间
     */
    private Date create_time;
    /**
     * 版块名称
     */
    private String plate_name;
    
    public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getPlate_name() {
		return plate_name;
	}
	public void setPlate_name(String plate_name) {
		this.plate_name = plate_name;
	}
	/**
     * 评论的内容
     * @return
     */
    private  List<postinglist>  map;

	public List<postinglist> getMap() {
		return map;
	}
	public void setMap(List<postinglist> map) {
		this.map = map;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
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
				+ number + ", numbers=" + numbers + ", name=" + name + ", title=" + title + ", context=" + context
				+ ", id=" + id + ", user_id=" + user_id  + ", nickname=" + nickname + ", avatar="
				+ avatar + ", create_time=" + create_time + ", plate_name=" + plate_name + ", map=" + map + "]";
	}
    
}
