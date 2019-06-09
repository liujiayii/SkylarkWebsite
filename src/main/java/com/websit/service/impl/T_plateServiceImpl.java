package com.websit.service.impl;

import com.websit.constant.ReturnCode;
import com.websit.entity.T_plate;
import com.websit.entity.T_tag;
import com.websit.entityvo.PlateCompanyVo;
import com.websit.mapper.T_plateMapper;
import com.websit.mapper.T_tagMapper;
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
	/** 标签表  */
	@Autowired
	private T_tagMapper t_tagMapper;

	/**
	 * 查询所有论坛分类以及对应版块信息
	 *
	 * @Title: selectAllPlates
	 * @description 
	 * @return  
	 * String   
	 * @author lujinpeng
	 * @createDate 2019年3月18日-上午11:23:48
	 */
	@Override
	public String selectAllPlates() {
		List<PlateCompanyVo> selectAllPlates = null;
		
		try {
			selectAllPlates = t_plateMapper.selectAllPlates();
			
			for (PlateCompanyVo pcv : selectAllPlates) {
				for (T_plate tp : pcv.getT_plate()) {
					//tp.setCommentCount(t_plateMapper.selectPlateCommentCount(tp.getId()));
				//	tp.setTagList(t_tagMapper.selectTags(new T_tag(null, null, tp.getId(), pcv.getId())));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, selectAllPlates.size(), selectAllPlates);
	}

	/* (non-Javadoc)
	 * @see com.websit.service.IT_plateService#selectFindId(long)
	 */
	@Override
	public T_plate selectFindId(long id) {
		// TODO Auto-generated method stub
		return t_plateMapper.selectFindId(id);
	}

	/**
	 *
	 * @Title: listCompanyPlate
	 * @description 2.1查询当前公司的所有板块列表
	 * @return  List<PlateCompanyVo>
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@Override
	public String listCompanyPlate(Long company_id) {
		// TODO Auto-generated method stub
		List<PlateCompanyVo> listCompanyPlate = null;
		int count = 0;
		try {
			listCompanyPlate = t_plateMapper.listCompanyPlate(company_id);
			count = t_plateMapper.countCompanyPlate(company_id);
			for (PlateCompanyVo pcv : listCompanyPlate) {
				for (T_plate tp : pcv.getT_plate()) {
					//tp.setCommentCount(t_plateMapper.selectPlateCommentCount(tp.getId()));
				//	tp.setTagList(t_tagMapper.selectTags(new T_tag(null, null, tp.getId(), pcv.getId())));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.getResponseJson(ReturnCode.EXCEPTION_CODE, ReturnCode.EXCEPTION_MSG, null, null);
		}
		
		return JsonUtil.getResponseJson(ReturnCode.SUCCSEE_CODE, ReturnCode.SUCCESS_SELECT_MSG, count, listCompanyPlate);
	}

	/**
	 *
	 * @Title: countCompanyPlate
	 * @description 2.2查询当前公司的所有板块列表的数量
	 * @return  int
	 * @author dujiawei
	 * @createDate 2019年6月3日
	 */
	@Override
	public int countCompanyPlate(Long company_id) {
		// TODO Auto-generated method stub
		return t_plateMapper.countCompanyPlate(company_id);
	}

	
	
}
