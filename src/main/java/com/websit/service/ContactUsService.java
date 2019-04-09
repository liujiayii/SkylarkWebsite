package com.websit.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.ContactUs;

public interface ContactUsService {
	/**
	 * 联系我们展示
	 *
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	public List<ContactUs> selectAllContactUsList();
	
	/**
	 * 查询联系我们条数
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	public Integer findContactUsCount(ContactUs contactUs);
	/**
	 * 联系我们展示--分页
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public List<ContactUs> selectAllContactUsListPage(@Param("page")Integer page,@Param("limit")Integer limit);
	/**
	 * 增加联系我们
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int saveContactUs(ContactUs contactUs);
	/**
	 * 修改联系我们
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int updateContactUs(ContactUs contactUs);
	/**
	 * description   根据id删除联系我们
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int deleteContactUsById(@Param("id") BigInteger id);

}
