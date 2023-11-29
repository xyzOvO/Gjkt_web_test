package com.xyz66.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz66.domain.ResponseResult;
import com.xyz66.domain.dto.SysUserAddDTO;
import com.xyz66.domain.entity.Article;
import com.xyz66.domain.entity.Comment;
import com.xyz66.domain.entity.SysUser;
import com.xyz66.service.ArticleService;
import com.xyz66.service.CommentService;
import com.xyz66.service.SysUserService;
import com.xyz66.utils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
public class SysUserControllerTest {
    @Autowired// @SpringBootTest完整启动Spring框架时，通过@Autowired完成依赖注入
    private SysUserController sysUserController;

    //    @Mock// 创建模拟对象
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;
    @Test
    public void testSelectOne() throws Exception {
        // 准备测试数据
        Serializable id = 1;
        SysUser sysUser = null;
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
        SysUser sysUser = null;
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
        System.out.println(JSON.toJSONString(list));
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
        SysUserAddDTO sysUserAddDTO1 = new SysUserAddDTO();
        sysUserAddDTO.setId(233L);
        sysUserAddDTO1.setId(111L);
        // 创建一个SysUserAddDTO对象的列表
        List<SysUserAddDTO> sysUserAddDTOList = new ArrayList<>();
        sysUserAddDTOList.add(sysUserAddDTO);
        sysUserAddDTOList.add(sysUserAddDTO1);

        // 调用BeanUtils工具类的transform方法，将SysUserAddDTO对象列表转换为SysUser对象列表
        List<SysUser> transform = BeanUtils.transform(sysUserAddDTOList, SysUser.class);
        transform.forEach(sysUser -> {
            if (sysUser.getId()==233L) {
                sysUser.setId(sysUser.getId() * 2);
            }
        });
        // 打印转换后的SysUser对象列表
        System.out.println(transform);
    }
    
    @Test
    public void cs5(){
        // 降序排序
        List<Article> list = articleService.lambdaQuery()
                .orderByDesc(Article::getCreateTime)
                .list();
        for (Article article : list) {
            System.out.println(article.getId());
        }
        System.out.println("————————————");
        // 升序排序
        List<Article> list2 = articleService.lambdaQuery()
                .orderByAsc(Article::getCreateTime)
                .list();
        for (Article article : list2) {
            System.out.println(article.getId());
        }
        System.out.println("————————————");
    }
    @Test
    public void cs6(){
        int pageNumber = 0;
        int pageSize = 2;
        List<Comment> records = commentService.lambdaQuery()
                // current:当前索引(决定是第几页) size:分页大小
                .page(new Page<>(pageNumber, pageSize))
                // 获取记录(分页)
                .getRecords();
        records.forEach(u-> System.out.println("分页查询："+u.getContent()));

    }
    @Test
    public void cs7(){
        // 表查询末尾-添加SQL语句(测试分组查询)
        List<Comment> records = commentService.lambdaQuery()
                .last("group by to_comment_user_id")
                .list();
        records.forEach(u-> System.out.println("分页查询："+u.getContent()));

    }

}
