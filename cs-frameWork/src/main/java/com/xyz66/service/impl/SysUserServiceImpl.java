package com.xyz66.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.domain.entity.SysUser;
import com.xyz66.mapper.SysUserMapper;
import com.xyz66.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-16 13:00:02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}

