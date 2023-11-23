package com.xyz66.controller;


import com.alibaba.fastjson.JSON;
import com.xyz66.domain.ResponseResult;
import com.xyz66.domain.entity.SysUser;
import com.xyz66.service.SysUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.Serializable;

import static org.mockito.Mockito.when;

public class SysUserControllerTest {

    @InjectMocks// 在单元测试中没有启动Spring框架时，通过@InjectMocks完成依赖注入
    private SysUserController sysUserController;

    @Mock// 创建模拟对象
    private SysUserService sysUserService;

    @BeforeEach// JUnit5 弃用Before,每个测试方法执行之前初始化测试环境
    public void setUp() {
        MockitoAnnotations.openMocks(this);// 初始化被@Mock、@Spy、@Captor 和 @InjectMocks 注解的字段
    }

    @Test
    public void testSelectOne() throws Exception {
        // 准备测试数据
        Serializable id = 1;
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUserName("admain");
        // 设置mock对象行为
        // 设置sysUserService的 getById 方法的返回值为 sysUser
        when(sysUserService.getById(id)).thenReturn(sysUser);
        // 调用被测试的方法
        // 调用 sysUserController 的 selectOne 方法，并传入 id 参数
        ResponseResult<SysUser> responseResult = sysUserController.selectOne(id);
        // 如果 responseResult 的 Code 字段等于 200
//        if (responseResult.getCode() == 200) {
//            // 打印 responseResult 的 JSON 字符串形式
//            System.out.println(JSON.toJSONString(responseResult));
//        }
        // 断言验证结果
        assert (responseResult.getData().getUserName().equals(sysUser.getUserName()));
    }
    @Test
    public void cs(){
        System.out.println("初始化？");
    }
}
