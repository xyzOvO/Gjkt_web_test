package com.xyz66.cs.cs2023年11月24日;

import io.swagger.models.auth.In;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/24 16:59
 */
public class cs2 {
    // 测试AtomicReference类
    private static AtomicReference<Integer> cs = new AtomicReference<>(10000);
    public static void main(String[] args) {

        cs_Thread cs_Thread = new cs_Thread(cs);
        Thread t1 = new Thread(cs_Thread);
        Thread t2 = new Thread(cs_Thread);
        Thread t3 = new Thread(cs_Thread);
        // 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        // 关闭线程
        pool.shutdown();
        
    }
}
