package com.websit.service.impl;

import java.math.BigInteger;
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
	
	/**
	 * 查询联系我们条数
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	@Override
	public Integer findContactUsCount(ContactUs contactUs) {
	
		return contactUsMapper.findContactUsCount(contactUs);
	}
	/**
	 * 联系我们展示--分页
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public List<ContactUs> selectAllContactUsListPage(Integer page, Integer limit) {
	
		return contactUsMapper.selectAllContactUsListPage(page, limit);
	}
	/**
	 * 增加联系我们
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int saveContactUs(ContactUs contactUs) {
	
		return contactUsMapper.saveContactUs(contactUs);
	}
	/**
	 * 修改联系我们
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int updateContactUs(ContactUs contactUs) {
		
		return contactUsMapper.updateContactUs(contactUs);
	}
	/**
	 * description   根据id删除联系我们
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	@Override
	public int deleteContactUsById(BigInteger id) {
		
		return contactUsMapper.deleteContactUsById(id);
	}
	

	


}
