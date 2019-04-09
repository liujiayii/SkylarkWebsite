package com.websit.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.OurAdvantages;
import com.websit.mapper.OurAdvantagesMapper;
import com.websit.service.OurAdvantagesService;
@Service
public class OurAdvantagesServiceImpl implements OurAdvantagesService{
	@Autowired
private OurAdvantagesMapper ourAdvantagesMapper;
	/**
	 * 我们的优势展示
	 *
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@Override
	public List<OurAdvantages> selectAllOurAdvantagesList() {
		
		return ourAdvantagesMapper.selectAllOurAdvantagesList();
	}
	/**
	 * 查询我们的优势条数
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@Override
	public Integer findOurAdvantagesCount(OurAdvantages ourAdvantages) {
		
		return ourAdvantagesMapper.findOurAdvantagesCount(ourAdvantages);
	}
	/**
	 * 我们的优势展示--分页
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public List<OurAdvantages> selectAllOurAdvantagesPage(Integer page, Integer limit) {
		
		return ourAdvantagesMapper.selectAllOurAdvantagesPage(page, limit);
	}
	/**
	 * 增加我们的优势
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int saveOurAdvantages(OurAdvantages ourAdvantages) {
	
		return ourAdvantagesMapper.saveOurAdvantages(ourAdvantages);
	}
	/**
	 * 修改我们的优势
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int updateOurAdvantages(OurAdvantages ourAdvantages) {
		
		return ourAdvantagesMapper.updateOurAdvantages(ourAdvantages);
	}
	/**
	 * description   根据id删除我们的优势
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int deleteOurAdvantagesById(BigInteger id) {
		
		return ourAdvantagesMapper.deleteOurAdvantagesById(id);
	}
	
	
	

	


}
