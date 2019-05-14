package com.websit.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.websit.entity.T_role_admin;
import com.websit.mapper.T_admin_roleMapper;
import com.websit.service.IT_admin_roleService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author lujinpeng
 * @since 2019-04-04
 */
@Service
public class T_user_roleServiceImpl extends ServiceImpl<T_admin_roleMapper, T_role_admin> implements IT_admin_roleService {

}
