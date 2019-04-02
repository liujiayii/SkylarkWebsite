package com.websit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websit.entity.ContactUs;
import com.websit.mapper.ContactUsMapper;
import com.websit.service.ContactUsService;
@Service
public class ContactUsServiceImpl implements ContactUsService{
	@Autowired
	private ContactUsMapper contactUsMapper;
	/**
	 * 联系我们展示
	 *
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@Override
	public List<ContactUs> selectAllContactUsList() {
		
		return contactUsMapper.selectAllContactUsList();
	}

}
