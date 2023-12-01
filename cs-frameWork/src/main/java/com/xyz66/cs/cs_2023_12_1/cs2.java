package com.xyz66.cs.cs_2023_12_1;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/12/1 16:18
 */
public class cs2 {
    @Test
    public void test() throws InterruptedException {
        // 创建一个阻塞队列
        // 编写1个生产者-3个消费者的模型
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // 1个生产者
        new Thread(() -> {
            // 生产20个元素
            for (int i = 0; i < 20; i++) {
                try {
                    // 生产元素如果满了阻塞等待
                    queue.put("元素_" + i);
                    System.out.println("生产者生产元素： " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // 3个消费者
        for (int i = 0; i < 3; i++) {
            final int index = i;
            new Thread(() -> {
                while (true) {
                    try {
                        // 消费元素，如果队列为空阻塞等待
                        System.out.println("消费者" + index + "消费元素： " + queue.take());
                        Thread.sleep(5000);// 延迟一下
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        Thread.sleep(40000);// 延迟30s，防止程序提前结束，导致消费者没有消费完毕
    }

    @Test
    public void test1() throws InterruptedException {
        // 创建一个同步阻塞队列
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        //  生产-->消费--> 生产--> 消费-->生产--> 消费.

        // 1个生产者
        new Thread(() -> {
            // 生产20个元素
            for (int i = 0; i < 20; i++) {
                try {
                    // 一个一个排队
                    queue.put("元素_" + i);
                    System.out.println("生产者生产元素： " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // x个消费者
        for (int i = 0; i < 1; i++) {
            final int index = i;
            new Thread(() -> {
                while (true) {
                    try {
                        // 消费元素，如果队列为空阻塞等待
                        System.out.println("消费者" + index + "消费元素： " + queue.take());
                        Thread.sleep(5000);// 延迟一下
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        Thread.sleep(40000);// 延迟30s，防止程序提前结束，导致消费者没有消费完毕
    }
    @Test
    public void test2() throws InterruptedException {
        // 创建一个传递队列
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        // 1个生产者
        new Thread(() -> {
            // 生产20个元素
            for (int i = 0; i < 20; i++) {
                try {
                    queue.transfer("元素_"+i);// 有消费者在等待，不存队列，直接传递；没有，入队阻塞等待，有消费唤醒
//                    System.out.println(queue.tryTransfer("元素_" + i));// 没有消费者在等待，不如队，返回false。有就直接传递并返回true
//                    System.out.println(queue.hasWaitingConsumer());// 是否有消费者在等待
//                    System.out.println(queue.getWaitingConsumerCount());// 获取等待的消费者数量
                    System.out.println("生产者生产元素： " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // x个消费者
        for (int i = 0; i < 2; i++) {
            final int index = i;
            new Thread(() -> {
                while (true) {
                    try {
                        // 消费元素，如果队列为空阻塞等待
                        System.out.println("消费者" + index + "消费元素： " + queue.take());
                        Thread.sleep(5000);// 延迟一下
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        Thread.sleep(40000);// 延迟30s，防止程序提前结束，导致消费者没有消费完毕
    }
}
