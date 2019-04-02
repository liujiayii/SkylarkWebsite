package com.websit.constant;

public enum ExpressReturnCodeEnum {

	
	SUCCESS("查询正常", 0), EXPRESS_NO_ERROE("快递单号错误", 201), EXPNAME_INEXISTENCE("快递公司不存在", 203),
	EXPNAME_DISCERN_FAILED("快递公司识别失败", 204), NO_INFORMATION("没有信息", 205), EXPRESS_NO_CONFINED("该单号被限制，错误单号", 207);

	private String name;
	private int index;
	private ExpressReturnCodeEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	/**
	 * 普通方法
	 *
	 * @Title: getInfo
	 * @description 
	 * @param index
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月25日-下午1:52:04
	 */
	public static String getInfo(int index) {
		
		for (ExpressReturnCodeEnum erc : ExpressReturnCodeEnum.values()) {
			
			if (erc.index == index) {
				
				return  erc.getName();
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
