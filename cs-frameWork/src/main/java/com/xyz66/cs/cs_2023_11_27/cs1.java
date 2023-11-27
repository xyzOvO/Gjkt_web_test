package com.xyz66.cs.cs_2023_11_27;

import com.xyz66.domain.entity.SysUser;
import com.xyz66.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/27 12:21
 */
@SpringBootTest
public class cs1 {
    @Autowired
    // 用户表(SysUser)表服务接口
    SysUserService sysUserService;

    @Test
    public void cs1() {
        // 查询总用户数
        long l = sysUserService.lambdaQuery().count().longValue();
        System.out.println(l);
    }

    @Test
    public void cs2() {
        // 统计对应值的Stream流使用
        long l = sysUserService.lambdaQuery()
                .gt(SysUser::getId, 6)
                .count()
                .longValue();
        System.out.println(l);
    }

    @Test
    public void cs3() {
        // .builder() 构造者模式
        SysUser sysUser = SysUser.builder()
                .id(2L)
                .sex("1")
                .delFlag(1)
                .build();
        System.out.println(sysUser.getId().toString());
    }
}
