package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_plate;
import com.websit.mapper.T_plateMapper;
import com.websit.service.IT_plateService;
import com.websit.until.JsonUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 板块表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_plateServiceImpl extends ServiceImpl<T_plateMapper, T_plate> implements IT_plateService {
	
	@Autowired
	private T_plateMapper t_plateMapper;
	
	/**
	 * 查询版块信息
	 */
	@Override
	public String selectPlateInfo() {
		List<T_plate> plateList = null;
		
		try {
			plateList = t_plateMapper.selectList(null);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, plateList.size(), plateList);
	}

	
	
}
