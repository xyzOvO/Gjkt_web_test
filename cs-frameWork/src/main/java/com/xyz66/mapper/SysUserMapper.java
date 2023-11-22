package com.xyz66.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyz66.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-16 13:00:02
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}

