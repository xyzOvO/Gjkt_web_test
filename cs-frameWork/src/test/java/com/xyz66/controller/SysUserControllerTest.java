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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SysUserControllerTest {
    @Autowired// @SpringBootTest完整启动Spring框架时，通过@Autowired完成依赖注入
    private SysUserController sysUserController;

    @Mock// 创建模拟对象
    private SysUserService sysUserService;

    @Test
    public void testSelectOne() throws Exception {
        // 准备测试数据
        Serializable id = 1;
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setUserName("admain");
        // 设置mock对象行为
        // 设置sysUserService的 getById 方法的返回值为 sysUser
//        when(sysUserService.getById(id)).thenReturn(sysUser);
        // 调用被测试的方法
        // 调用 sysUserController 的 selectOne 方法，并传入 id 参数
        ResponseResult<SysUser> responseResult = sysUserController.selectOne(id);
        // 如果 responseResult 的 Code 字段等于 200
//        if (responseResult.getCode() == 200) {
//            // 打印 responseResult 的 JSON 字符串形式
//            System.out.println(JSON.toJSONString(responseResult));
//        }
        // 断言验证结果
        assert (responseResult.getData().getId().equals(sysUser.getId()));
    }

    @Test
    @Transactional// 当该注解标注的方法抛出 Exception 类型的异常时，Spring 会回滚当前的事务。
//    @Transactional(rollbackFor = Exception.class)
//    @Rollback(value = false)// 关闭回滚
//    @Commit
    @Rollback
    public void insertText() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("cs");
        sysUser.setAvatar("cs");
        sysUser.setSex("1");
        List<Long> ids = new ArrayList<>();
        ids.add(14787164048675L);
        ResponseResult cs = sysUserController.delete(ids);
        System.out.println(JSON.toJSONString(cs));
    }
}
