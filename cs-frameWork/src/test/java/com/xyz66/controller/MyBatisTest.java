package com.xyz66.controller;

import com.xyz66.web.domain.entity.Message;
import com.xyz66.web.service.MessageService;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gjkt
 * @since 2023/12/26 16:04
 */
@SpringBootTest
@Log
public class MyBatisTest {

    @Autowired
    private MessageService messageService;
    @Test
    @Transactional
    public void cs1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试：");// 开始计时
//        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Message message = new Message();
            String s = "测试：" + i;
            message.setMessage(s);
            // 一条一条插入
            messageService.save(message);
        }
        // 停止计时
        stopWatch.stop();
        log.info("一条一条插入所花费：" + stopWatch.getTotalTimeMillis());
    }
    @Test
    @Transactional
    public void cs2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试：");// 开始计时
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Message message = new Message();
            String s = "测试：" + i;
            message.setMessage(s);
            list.add(message);
        }
        // 批量插入
        messageService.saveBatch(list);
        // 停止计时
        stopWatch.stop();
        log.info("批量插入所花费：" + stopWatch.getTotalTimeMillis());
    }
}
