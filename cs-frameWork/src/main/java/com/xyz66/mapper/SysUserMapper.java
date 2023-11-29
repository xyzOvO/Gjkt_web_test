package com.xyz66.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.xyz66.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.List;


/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-16 13:00:02
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    // 自定义sql

//    @Select("select * from sys_user ${ew.customSqlSegment}")// customSqlSegment好像是自己的拓展
    @Select("select * from sys_user ")
    List<SysUser> getAll(@Param(Constants.WRAPPER) Wrapper wrapper);

}

