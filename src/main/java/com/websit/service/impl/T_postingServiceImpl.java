package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_posting;
import com.websit.entityvo.T_postingVo;
import com.websit.mapper.T_postingMapper;
import com.websit.service.IT_postingService;
import com.websit.until.JsonUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;

import javax.annotation.Resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发帖表 服务实现类
 * </p>
 *
 * @author lichangchun
 * @since 2019-03-13
 */
@Service
public class T_postingServiceImpl extends ServiceImpl<T_postingMapper, T_posting> implements IT_postingService {

	@Autowired
	private T_postingMapper t_postingMapper;
	
	/**
	 * 查询热门帖子
	 */
	@Override
	public String showHotPostings(Integer row) {
		List<T_posting> postingList = null;
		
		try {
			postingList = t_postingMapper.selectHotPotings(row);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, postingList.size(), postingList);
	}

	/**
	 * 查询最新帖子
	 */
	@Override
	public String showNewestPotings(Integer row) {
		
		List<T_posting> postingList = null;
		
		try {
			postingList = t_postingMapper.selectNewestPotings(row);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, postingList.size(), postingList);
	}
 

	@Resource
	private T_postingMapper postingMapper;
	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表                                                                  
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月14日
	 */
	@Override
	public List<T_postingVo> selecAllSome(T_postingVo postingVo) {
		return t_postingMapper.selecAllSome(postingVo);
	}

}
