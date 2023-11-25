package com.xyz66.cs.cs2023年11月24日;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {


//    @Test
//    public void cs() {
//        //        System.out.println(atomicRef.get());
//        //        System.out.println(cs);
//    }
//
//    @Test
//    public void cs1() {
//        // 原子引用,保证线程安全
//        AtomicReference<Integer> atomicRef = new AtomicReference<>(0);
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                atomicRef.set(atomicRef.get() + 1);
//                System.out.println("线程1设置的值为：" + atomicRef.get());
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                atomicRef.set(atomicRef.get() + 1);
//                System.out.println("线程2设置的值为：" + atomicRef.get());
//            }
//        });
//
//        t1.start(); // 启动线程1  
//        t2.start(); // 启动线程2  
//
//        try {
//            t1.join(); // 等待线程1执行结束  
//            t2.join(); // 等待线程2执行结束  
//            // 不然主线程会立即结束，而线程1和线程2还没有执行完，直接打印。
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("最终的值为：" + atomicRef.get()); // 打印最终的值  
//    }
//
//    @Test
//    public void cs2() {
//        // 普通遍历线程不安全的
//        final Integer[] cs = {0};
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                cs[0]++;
//                System.out.println("线程1设置的值为：" + cs[0]);
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                cs[0]++;
//                System.out.println("线程2设置的值为：" + cs[0]);
//            }
//        });
//
//        t1.start(); // 启动线程1  
//        t2.start(); // 启动线程2  
//
//        try {
//            t1.join(); // 等待线程1执行结束  
//            t2.join(); // 等待线程2执行结束  
//            // 不然主线程会立即结束，而线程1和线程2还没有执行完，直接打印。
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("最终的值为：" + cs[0]); // 打印最终的值  
//    }

    @Test
    public void cs3() throws InterruptedException {
        AtomicReference<Integer> atomicRef = new AtomicReference<>(0);
        int numThreads = 10;
        int numIncrements = 1000;

        // 创建一个线程池，包含10个线程  
        ExecutorService executorService = Executors.newFixedThreadPool(numIncrements);

        // 测试原子引用  
        // 每个线程对AtomicReference进行1000次增量操作
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < numIncrements; j++) {
                    atomicRef.updateAndGet(value -> value + 1);
                    System.out.println(Thread.currentThread().getName() + " : " + atomicRef.get());
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待线程池执行结束

        // 输出最终的值  
        System.out.println("AtomicReference的值: " + atomicRef.get());
    }
    
    @Test
    public void cs4() throws InterruptedException {
        final Integer[] cs = {0};
        int numThreads = 10;
        int numIncrements = 1000;

        // 创建一个线程池，包含10个线程  
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // 测试原子引用  
        // 每个线程对AtomicReference进行1000次增量操作
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < numIncrements; j++) {
                    cs[0] = cs[0] +1;
                    System.out.println(cs[0]);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待线程池执行结束

        // 输出最终的值  
        System.out.println("AtomicReference的值: " + cs[0]);
    }
}
