package com.websit.entityvo;

import java.util.List;

import com.websit.entity.T_express;
import com.websit.entity.T_express_details;

/**
 * 快递公司表和快递详情表拓展类
 *
 * @ClassName: ExpressDetailsVo

 * @description 
 *
 * @author lujinpeng
 * @createDate 2019年3月21日-下午3:03:33
 */
public class ExpressDetailsVo extends T_express {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 快递详情列表
	 */
	List<T_express_details> expressDetail;

	public List<T_express_details> getExpressDetail() {
		return expressDetail;
	}

	public void setExpressDetail(List<T_express_details> expressDetail) {
		this.expressDetail = expressDetail;
	}

	@Override
	public String toString() {
		return "ExpressDetailsVo [expressDetail=" + expressDetail + "]";
	}
	
}
