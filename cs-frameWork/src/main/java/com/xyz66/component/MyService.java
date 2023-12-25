package com.xyz66.component;

import com.alibaba.fastjson2.JSON;
import com.xyz66.web.domain.entity.Article;
import com.xyz66.web.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component  
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest
public class MyService {  
    private final ArticleService articleService;

    @Test
    public void doSomething() {
        List<Article> list = articleService.list();
        System.out.println(JSON.toJSON(list));
    }  
}