package com.xyz66.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyz66.web.domain.entity.Comment;
import com.xyz66.web.mapper.CommentMapper;
import com.xyz66.web.service.ArticleService;
import com.xyz66.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 16:54:37
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    
    @Autowired
    private ArticleService articleService;// 循环依赖测试
    public void test() {
        articleService.lambdaQuery().list().forEach(System.out::println);
    }
}

