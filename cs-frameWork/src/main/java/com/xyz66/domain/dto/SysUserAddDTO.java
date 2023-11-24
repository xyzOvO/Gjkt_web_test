package com.xyz66.domain.dto;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(SysUser)表实体类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-24 14:06:43
 */
@SuppressWarnings("serial")
// 如果编译器出现这样的警告信息：
// The serializable class WmailCalendar does not declare a static final serialVersionUID field of type long
// 使用这个注释将警告信息去掉。
@Data
public class SysUserAddDTO implements Serializable {
    //主键
    private Long id;
    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0女，1男，2未知）
}

