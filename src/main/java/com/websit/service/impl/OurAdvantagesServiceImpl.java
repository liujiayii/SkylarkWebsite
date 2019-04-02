package com.websit.service.impl;

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
}
