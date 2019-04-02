package com.websit.constant;

/**
 * 返回客户端消息常量值
 *
 * @ClassName: ReturnCode

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月14日-下午5:05:53
 */
public class ReturnCode {

	//成功返回的code值
	public static final int SUCCSEE_CODE = 1;
	
	//系统异常返回的code值
	public static final int EXCEPTION_CODE = -1;
	
	//查询成功返回消息
	public static final String SUCCESS_SELECT_MSG = "查询成功";
	
	//查询成功返回消息
	public static final String NORESULT_SELECT_MSG = "无数据";
	
	//查询失败返回消息
	public static final String FAILED_SELECT_MSG = "查询失败";
	
	//更新成功返回消息
	public static final String SUCCESS_UPDATE_MSG = "修改成功";
	
	//更新失败返回消息
	public static final String FAILED_UPDATE_MSG = "修改失败";
	
	//添加成功返回消息
	public static final String SUCCESS_INSERT_MSG = "添加成功";
	
	//添加失败返回消息
	public static final String FAILED_INSERT_MSG = "添加失败";
	
	//删除成功返回消息
	public static final String SUCCESS_DELETE_MSG = "删除成功";
	
	//删除失败返回消息
	public static final String FAILED_DELETE_MSG = "删除失败";
	
	//系统异常返回消息
	public static final String EXCEPTION_MSG = "系统异常";
	
}
