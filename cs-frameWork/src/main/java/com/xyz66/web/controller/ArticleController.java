package com.xyz66.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyz66.web.domain.ResponseResult;
import com.xyz66.web.domain.entity.Article;
import com.xyz66.web.domain.entity.Comment;
import com.xyz66.web.domain.entity.Message;
import com.xyz66.web.domain.entity.MessageLongTest;
import com.xyz66.web.service.ArticleService;
import com.xyz66.web.service.CommentService;
import com.xyz66.web.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 文章表(Article)表控制层
 *
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023-11-28 15:09:13
 */
//@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController{
    /**
     * 服务对象
     */
//    @Autowired
    private final ArticleService articleService;
    private final CommentService commentService;

//    public ArticleController(ArticleService articleService) {
//        // 构造器注入
//        this.articleService = articleService;
//    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param article 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Article> page, Article article) {
        return ResponseResult.okResult(this.articleService.page(page, new QueryWrapper<>(article)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("{id}")
//    public ResponseResult selectOne(@PathVariable Serializable id) {
//        return ResponseResult.okResult(this.articleService.getById(id));
//    }

    /**
     * 新增数据
     *
     * @param article 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Article article) {
        return ResponseResult.okResult(this.articleService.save(article));
    }

    /**
     * 修改数据
     *
     * @param article 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Article article) {
        return ResponseResult.okResult(this.articleService.updateById(article));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.articleService.removeByIds(idList));
    }

    // todo:测试用
    @PreAuthorize("@csService.cs('SpringSecurity测试雪豹')")
    @PostMapping("/cs")
    public ResponseResult cs(){
        List<Article> list = articleService.lambdaQuery()
                .like(Article::getSummary, "雪豹")
                .list();
        return ResponseResult.okResult(list);
    }

    @GetMapping("/cs2")
//    @ResponseBody// 返回json数据,Spring 4.0开始@RestController默认返回json数据
    public List<Article> cs2(){
//        return "{'test2':'cs2','test3':'cs3','test4':'cs4'}";
        List<Article> list = articleService.lambdaQuery()
                .like(Article::getSummary, "雪豹")
               .list();
        return list;
    }
    @GetMapping("/cs3")
    public ResponseResult cs3(){
        return ResponseResult.okResult(commentService.lambdaQuery()
               .like(Comment::getContent, "测试")
               .list());
    }
    
    @Autowired
    private MessageService messageService;
    @PostMapping("/cs4")
    public ResponseResult cs4(@Valid @RequestBody Message message){
        // @Valid 验证实体类
//        List<Message> list = new ArrayList<>();
//        list.add(message);
//        System.out.println(list);
//        return ResponseResult.okResult("添加成功");
        return ResponseResult.okResult(messageService.save(message));
    }
    @PostMapping("/cs5")
    public ResponseResult cs5(@RequestBody MessageLongTest message){
        // 前端传回来的id精度丢失
        String s = "d44ee51e44764d41ba1cf334ed3e0af3";
        Message message1 = new Message();
        message1.setMessage(message.getMessage().toString());
        return ResponseResult.okResult(messageService.save(message1));
    } 
    
//    @CachePut(cacheNames = "TestName",key = "#message.message")// 执行就缓存，动态获取message(Long)字段
    @Cacheable(value = "cs",key = "#message.message",unless = "#message==null")
    @PostMapping("/cs6")
    public ResponseResult cs6(@RequestBody MessageLongTest message){
        // 测试spring-cache
        String s = "d44ee51e44764d41ba1cf334ed3e0af3";
        Message message1 = new Message();
        message1.setMessage(message.getMessage().toString());
        return ResponseResult.okResult(messageService.save(message1));
    } 
    @CacheEvict(value = "cs",key = "#message.message",allEntries = true)// 根据缓存名称清空所有数据
    @PostMapping("/cs7")
    public ResponseResult cs7(@RequestBody MessageLongTest message){
        // 清空全部缓存
        String s = "d44ee51e44764d41ba1cf334ed3e0af3";
        Message message1 = new Message();
        message1.setMessage(message.getMessage().toString());
        return ResponseResult.okResult(messageService.save(message1));
    }

    @Cacheable(value = "cs8",key = "#message.message",unless = "#message==null")// 存入数据库的操作不要这样玩，程序会直接从内存读方法运行，直接不跑方法体就只能存一次数据库
    @PostMapping("/cs8")
    public ResponseResult cs8(@RequestBody MessageLongTest message){
        // 看看耗时
        String s = "d44ee51e44764d41ba1cf334ed3e0af3";
        Message message1 = new Message();
        message1.setMessage(message.getMessage().toString());
        return ResponseResult.okResult(messageService.save(message1));
    }
}

