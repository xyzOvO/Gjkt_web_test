package com.xyz66.controller;


import com.alibaba.fastjson.JSON;
import com.xyz66.domain.ResponseResult;
import com.xyz66.domain.dto.SysUserAddDTO;
import com.xyz66.domain.entity.SysUser;
import com.xyz66.service.SysUserService;
import com.xyz66.utils.BeanUtils;
import io.swagger.models.auth.In;
import org.apache.commons.collections4.CollectionUtils;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

//@SpringBootTest
public class SysUserControllerTest {
    @Autowired// @SpringBootTest完整启动Spring框架时，通过@Autowired完成依赖注入
    private SysUserController sysUserController;

    //    @Mock// 创建模拟对象
    @Autowired
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

    @Test
    public void cs1() {
        List<SysUser> list = sysUserService.lambdaQuery()
                .list();
        // 映射关系的使用（用户表和用户ID）
        Map<SysUser, String> collect = list.stream()
                .collect(Collectors.toMap(Function.identity(), SysUser::getUserName));
        System.out.println(JSON.toJSONString(collect));
//        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void cs2() {
        List<Integer> cs = new ArrayList<>();
        List<SysUser> list = sysUserService.lambdaQuery()
                .list();
        // 测试遍历
        list.forEach(sysUser -> {
            System.out.println(sysUser);
        });
    }

    @Test
    public void cs3() {
        // 试试CollectionUtils.isNotEmpty()
        List<Integer> cs = new ArrayList<>();
        Collections.addAll(cs, 1, 2, 3, 4, 5);
        System.out.println(CollectionUtils.isNotEmpty(cs));// 不为空？
        System.out.println(CollectionUtils.isNotEmpty(null));
    }

    @Test
    public void cs4() {
        // 创建一个SysUserAddDTO对象
        SysUserAddDTO sysUserAddDTO = new SysUserAddDTO();
        sysUserAddDTO.setId(233L);

        // 创建一个SysUserAddDTO对象的列表
        List<SysUserAddDTO> sysUserAddDTOList = new ArrayList<>();
        sysUserAddDTOList.add(sysUserAddDTO);

        // 调用BeanUtils工具类的transform方法，将SysUserAddDTO对象列表转换为SysUser对象列表
        List<SysUser> transform = BeanUtils.transform(sysUserAddDTOList, SysUser.class);

        // 打印转换后的SysUser对象列表
        System.out.println(transform);
    }

}
