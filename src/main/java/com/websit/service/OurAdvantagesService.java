package com.websit.service;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.websit.entity.OurAdvantages;

public interface OurAdvantagesService {
	/**
	 * 我们的优势展示
	 *
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	public List<OurAdvantages> selectAllOurAdvantagesList();
	/**
	 * 查询我们的优势条数
	 * @author pangchong
	 * @createDate 2019年4月2日 下午2:00
	 */
	public Integer findOurAdvantagesCount(OurAdvantages ourAdvantages);
	
	/**
	 * 我们的优势展示--分页
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public List<OurAdvantages> selectAllOurAdvantagesPage(@Param("page")Integer page,@Param("limit")Integer limit);
	/**
	 * 增加我们的优势
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int saveOurAdvantages(OurAdvantages ourAdvantages);
	/**
	 * 修改我们的优势
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int updateOurAdvantages(OurAdvantages ourAdvantages);
	/**
	 * description   根据id删除我们的优势
	 *
	 * @author pangchong
	 * @createDate 2019年4月3日 下午2:00
	 */
	public int deleteOurAdvantagesById(@Param("id") BigInteger id);

}
