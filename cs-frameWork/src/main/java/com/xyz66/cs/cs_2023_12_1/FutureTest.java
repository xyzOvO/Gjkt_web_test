package com.xyz66.cs.cs_2023_12_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool(); // 线程池
        Future<String> future = executor.submit(() ->{
            Thread.sleep(200); // 模拟接口调用，耗时200ms
            return "hello world";
        });
        // 在输出下面异步结果时主线程可以不阻塞的做其他事情
        // TODO 其他业务逻辑

        System.out.println("异步结果:"+future.get(1, TimeUnit.SECONDS)); //主线程获取异步结果,等一秒超时报错
        // 或者通过下面轮询的方式
        // while(!future.isDone());
    }
}

