package com.websit.service.impl;

import com.websit.entity.T_posting;
import com.websit.mapper.T_postingMapper;
import com.websit.service.IT_postingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
