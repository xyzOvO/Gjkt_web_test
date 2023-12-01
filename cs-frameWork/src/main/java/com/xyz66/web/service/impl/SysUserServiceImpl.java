package com.xyz66.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.web.domain.entity.SysUser;
import com.xyz66.web.mapper.SysUserMapper;
import com.xyz66.web.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 14:42:12
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}

