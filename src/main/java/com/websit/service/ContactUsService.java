package com.websit.service;

import java.util.List;

import com.websit.entity.ContactUs;

public interface ContactUsService {
	/**
	 * 联系我们展示
	 *
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	public List<ContactUs> selectAllContactUsList();
}
