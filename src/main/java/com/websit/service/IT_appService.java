package com.websit.service;

import com.websit.entity.T_app;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * app版本控制 服务类
 * </p>
 *
 * @author lichangchun
 * @since 2019-04-15
 */
public interface IT_appService extends IService<T_app> {
	public boolean uodatevison(T_app app);

}
