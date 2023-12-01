package com.xyz66.cs.cs_2023_12_1;

import com.xyz66.AOP.annotation.cs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/1 13:46
 */
@SpringBootTest// AOP是spring的特性，需要在测试类上加上@SpringBootTest
public class cs1 {
    @Test
    @cs(value = "123")
    public void test() {
        System.out.println("AOP加强的方法。");
    }

    @Test
    public void test4() throws InterruptedException {
        // 创建一个阻塞队列
        // 编写1个生产者-3个消费者的模型
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // 1个生产者
        new Thread(() -> {
            // 生产20个元素
            for (int i = 0; i < 20; i++) {
                try {
                    // 生产元素如果满了阻塞等待
                    queue.put("元素_"+i);
                    System.out.println("生产者生产元素： " + i);
//                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // 3个消费者
        for (int i = 0; i < 3; i++) {
            final int index = i;
            new Thread(() -> {
                while (true){
                    try {
                        // 消费元素，如果队列为空阻塞等待
                        System.out.println("消费者"+index+"消费元素： " + queue.take());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        Thread.sleep(30000);
    }

}
