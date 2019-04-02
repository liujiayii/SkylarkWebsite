package com.websit.constant;

public enum AlipayReturnEnum {

	WAIT_BUYER_PAY("交易创建，等待买家付款", 0), TRADE_CLOSED("未付款交易超时关闭，或支付完成后全额退款", 1),
	TRADE_SUCCESS("交易支付成功", 2), TRADE_FINISHED("交易结束，不可退款", 3);
	
	private String name;
	private int index;
	
	private AlipayReturnEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	/**
	 * 通过index获取name值
	 *
	 * @Title: getName
	 * @description 
	 * @param index
	 * @return  
	 * String    
	 * @author lujinpeng
	 * @createDate 2019年3月27日-下午2:11:10
	 */
	public static String getName(int index) {
		for (AlipayReturnEnum are : AlipayReturnEnum.values()) {
			
			if (are.index == index) {
				return are.name;
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
