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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
public class ControllerTest {
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
            if (sysUser.getId() == 233L) {
                sysUser.setId(sysUser.getId() * 2);
            }
        });
        // 打印转换后的SysUser对象列表
        System.out.println(transform);
    }

    @Test
    public void cs5() {
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
    public void cs6() {
        int pageNumber = 0;
        int pageSize = 2;
        List<Comment> records = commentService.lambdaQuery()
                // current:当前索引(决定是第几页) size:分页大小
                .page(new Page<>(pageNumber, pageSize))
                // 获取记录(分页)
                .getRecords();
        records.forEach(u -> System.out.println("分页查询：" + u.getContent()));

    }

    @Test
    public void cs7() {
        // 表查询末尾-添加SQL语句(测试分组查询)
        List<Comment> records = commentService.lambdaQuery()
                .last("group by to_comment_user_id")
                .list();
        records.forEach(u -> System.out.println("表查询末尾：" + u.getContent()));

    }

    @Test
    public void cs8() {
        // 模糊查询
        List<Comment> records = commentService.lambdaQuery()
//                .like(Comment::getContent,"哈哈哈")
//                .likeRight(Comment::getContent,"什么")// 右通配符(什么%)，开头
                .likeLeft(Comment::getContent, "什么")// 左通配符(%什么)，结尾
                .list();
        records.forEach(u -> System.out.println("模糊查询：" + u.getContent()));

    }

    @Test
    public void cs9() {
        // 范围查询，查有的xx(对应！)的，
        List<String> fw = Arrays.asList("asS", "a");
        List<Comment> records = commentService.lambdaQuery()
//                .notIn(Comment::getContent,fw)
                .in(Comment::getContent, fw)
                .list();
        records.forEach(u -> System.out.println("范围查询：" + u.getContent()));
    }

    @Test
    public void cs10() {
        // 模拟传入评论对象
        Comment cs = Comment.builder()
                .content("是大多数")
                .build();
        // 条件判断查询
        List<Comment> records = commentService.lambdaQuery()
                .eq(cs.getContent() != null, Comment::getContent, "你说啥？")
                .like(cs.getId() != null, Comment::getId, "2")
                .list();
        records.forEach(u -> System.out.println("条件查询：" + u.getContent()));
    }

    @Test
    public void cs11() {
        // 利用 or 和 and 构建复杂的查询条件
        List<Comment> records = commentService.lambdaQuery()
                .eq(Comment::getCreateBy, 14787164048662L)
                .and(Wrapper -> Wrapper.eq(Comment::getContent, "说你咋地")
                        // 大于等于
                        .or().ge(Comment::getId, 30))
                .list();

        records.forEach(u -> System.out.println("复杂查询：" + u.getContent()));
    }

    @Test
    public void cs12() {
        // 更新条件构造器：LambdaUpdateWrapper
//        commentService.update();
        commentService.lambdaUpdate()
                .set(Comment::getArticleId, 233L)
                .set(Comment::getContent, "测试测试123")
                // 更新ID为32的数据
                .eq(Comment::getId, 32L)
                .update();
    }

    @Test
    public void cs13() {
        // Association 标签适用于表和表之间存在一对一的关联关系，如用户和身份证存在一个人只会有一个身份证号，反过来也成立。
    }

    @Test
    public void cs14() {
        // 新增用户字段填充测试
        SysUser cs = SysUser.builder()
                .nickName("cs")
                .password("123")
                .build();
        sysUserService.save(cs);
        List<SysUser> cs1 = sysUserService.lambdaQuery()
                .eq(SysUser::getNickName, "cs").list();
        cs1.forEach(c-> System.out.println(c.getCreateTime()));
    }

}
