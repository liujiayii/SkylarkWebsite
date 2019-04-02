package com.websit.constant;

/**
 * 运单快递状态
 *
 * @ClassName: ExpressEnum

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月20日-下午6:06:53
 */
public enum ExpressEnum {

	COLLECT_MATERIALS("揽件", 0), ON_PASSAGE("在途中", 1), DELIVERY("正在派件", 2), SIGN_FOR("已签收", 3), 
	SEND_FAILED("派送失败", 4), DIFFICULT("疑难件", 5), BACK_TO_SIGN("退件签收", 6),;
	
	private String name;
	private int index;
	private ExpressEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	/**
	 * 普通方法
	 *
	 * @Title: getName
	 * @description 
	 * @param index
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月20日-下午6:25:36
	 */
	public static String getName(int index) {
		
		for (ExpressEnum ee : ExpressEnum.values()) {
			
			if (ee.getIndex() == index) {
				return ee.getName();
			}
			
		}
		
		return null;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
