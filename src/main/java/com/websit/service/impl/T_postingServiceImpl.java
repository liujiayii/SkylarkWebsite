package com.websit.service.impl;

import com.websit.constant.PostingType;
import com.websit.constant.ReturnCode;
import com.websit.entity.T_comment;
import com.websit.entity.T_posting;
import com.websit.entity.T_user;
import com.websit.entityvo.PostingPlateVo;
import com.websit.entityvo.T_postingVo;
import com.websit.mapper.T_postingMapper;
import com.websit.service.IT_postingService;
import com.websit.until.JsonUtil;

import io.netty.util.internal.StringUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showHotPostings(Integer page, Integer row) {
		List<PostingPlateVo> postingList = null;
		String msg = ReturnCode.SUCCESS_SELECT_MSG;
		
		if (page != null && row != null) {
			page = row * (page - 1); 
		}
		
		try {
			postingList = t_postingMapper.selectHotPotings(page, row);
			
			if (postingList == null || postingList.size() == 0) {
				msg = ReturnCode.NORESULT_SELECT_MSG;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, msg, postingList.size(), postingList);
	}

	/**
	 * 查询最新帖子
	 */
	@Override
	public String showNewestPotings(Long plate_id, Integer row) {
		
		List<PostingPlateVo> postingList = null;
		
		try {
			postingList = t_postingMapper.selectNewestPotings(plate_id, row);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, postingList.size(), postingList);
	}
 
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

	/**
	 * 查询精华帖子
	 *
	 * @Title: showGoodPosting
	
	 * @description 
	 *
	 * @param row 查询精华帖子数量
	 * @return 
	   
	 * String
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月15日-上午9:45:46
	 */
	public String showGoodPostings(Integer row) {
		
		List<PostingPlateVo> postingList = null;
		
		try {
			postingList = t_postingMapper.selectGoodPostings(PostingType.IS_GOOD, row);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, postingList.size(), postingList);
	}

	/**
	 * @Title: selectPostingCount
	 * @description 查询个人贴子数量
	 * @return List<T_postingVo> 
	 * @author pangchong
	 * @createDate 2019年03月15日
	 */
	@Override
	public Integer selectPostingCount() {
		
		return t_postingMapper.selectPostingCount();
	}

	/**
	 * @Title: selecAllSome
	 * @description 查询版主下的话题列表条数
	 * @return T_postingVo
	 * @author linhongyu
	 * @createDate 2019年03月15日
	 */
	@Override
	public T_postingVo selectCountTwo(T_postingVo postingVo) {
		// TODO Auto-generated method stub
		return t_postingMapper.selectCountTwo(postingVo);
	}
	
	/**
	 * 发帖计数
	 */
	public String selectPostCounts() {
		Map<String, Object> map = new HashMap<> ();
		// 今天发帖数
		int todayCount = 0;
		// 昨天发帖数
		int yesterdayCount = 0;
		// 总发帖数
		int totalPostCount = 0;
		// 会员总数
		int userCount = 0;
		
		try {
			todayCount = t_postingMapper.selectCount(this.selectPostCounts("to_days(create_time) - to_days(now())", "0"));
			yesterdayCount = t_postingMapper.selectCount(this.selectPostCounts("to_days(now()) - to_days(create_time)", "1"));
			totalPostCount = t_postingMapper.selectCount(null);
			userCount = new T_user().selectCount(null);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		map.put("todayCount", todayCount);
		map.put("yesterdayCount", yesterdayCount);
		map.put("totalPostCount", totalPostCount);
		map.put("userCount", userCount);
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, totalPostCount, map);
		
	}
	
	/**
	 * 重载发帖计数方法
	 *
	 * @Title: selectPostCount
	 * @description 
	 *
	 * @param param1
	 * @param param2
	 * @return 
	   
	 * Wrapper<T_posting>
	 *
	 * @author lujinpeng
	 * @createDate 2019年3月15日-下午12:02:34
	 */
	public Wrapper<T_posting> selectPostCounts(String param1, String param2) {
		if (StringUtil.isNullOrEmpty(param1) || StringUtil.isNullOrEmpty(param2)) {
			return null;
		}
		
		EntityWrapper<T_posting> ew = new EntityWrapper<> ();
		ew.eq(param1, param2);
		
		return ew;
	}

	/**
	 * @Title: selecAllSomeTop
	 * @description 查询版主下的话题列表置顶
	 * @return List<T_postingVo> 
	 * @author linhongyu
	 * @createDate 2019年03月19日
	 */
	@Override
	public List<T_postingVo> selecAllSomeTop(T_postingVo postingVo) {
		return t_postingMapper.selecAllSomeTop(postingVo);
	}

}
