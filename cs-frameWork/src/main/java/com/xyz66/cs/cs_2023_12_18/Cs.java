package com.xyz66.cs.cs_2023_12_18;

import com.xyz66.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author YangJiaJi
 * @date: 2023-12-18 16:32
 */
@Component// 让spring容器自动检测到这个类
public class Cs implements ApplicationRunner {
    @Autowired
    private TestService testService;// 手动装配要去扫描
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("启动的时候运行一些特定代码。");
        System.out.println(testService.test());
    }
}
