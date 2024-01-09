package com.xyz66.cs.cs2023年11月24日;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class AtomicReferenceTest {


    @Test
    public void cs() {
        //        System.out.println(atomicRef.get());
        //        System.out.println(cs);
    }

    @Test
    public void cs1() {
        // 原子引用,保证线程安全
        AtomicReference<Integer> atomicRef = new AtomicReference<>(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                // 加=，才能跑满10000-0
                atomicRef.set(atomicRef.get() + 1);
                log.info("线程1设置的值为：" + atomicRef.get());
//                System.out.println("线程1设置的值为：" + atomicRef.get());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                atomicRef.set(atomicRef.get() + 1);
                log.info("线程2设置的值为：" + atomicRef.get());
//                System.out.println("线程2设置的值为：" + atomicRef.get());
            }
        });

        t1.start(); // 启动线程1  
        t2.start(); // 启动线程2  

        try {
            t1.join(); // 等待线程1执行结束  
            t2.join(); // 等待线程2执行结束  
            // 不然主线程会立即结束，而线程1和线程2还没有执行完，直接打印。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("最终的值为：" + atomicRef.get());
//        System.out.println("最终的值为：" + atomicRef.get()); // 打印最终的值  
    }

    @Test
    public void cs2() {
        // 普通遍历线程不安全的
        final Integer[] cs = {0};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                cs[0]++;
                log.info("线程1设置的值为：" + cs[0]);
//                System.out.println("线程1设置的值为：" + cs[0]);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                cs[0]++;
                log.info("线程2设置的值为：" + cs[0]);
//                System.out.println("线程2设置的值为：" + cs[0]);
            }
        });

        t1.start(); // 启动线程1  
        t2.start(); // 启动线程2  

        try {
            t1.join(); // 等待线程1执行结束  
            t2.join(); // 等待线程2执行结束  
            // 不然主线程会立即结束，而线程1和线程2还没有执行完，直接打印。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("最终的值为：" + cs[0]);
//        System.out.println("最终的值为：" + cs[0]); // 打印最终的值  
    }

    @Test
    public void cs3() throws InterruptedException {
        // 线程池测试AtomicReference，关键测试
        AtomicReference<Integer> atomicRef = new AtomicReference<>(0);
        int numThreads = 10;
        int numIncrements = 1000;

        // 创建一个线程池，包含10个线程    
        ExecutorService executorService = Executors.newFixedThreadPool(numIncrements);

        // 测试原子引用    
        // 每个线程对AtomicReference进行1000次增量操作-锁死
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < numIncrements; j++) {
                    atomicRef.updateAndGet(value -> value + 1);
                    log.info(String.valueOf(atomicRef.get()));
//                    System.out.println(Thread.currentThread().getName() + " : " + atomicRef.get());
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待线程池执行结束  

        // 输出最终的值    
//        System.out.println("AtomicReference的值: " + atomicRef.get());
        log.info("AtomicReference的值: " + atomicRef.get());
    }

    @Test
    public void cs4() throws InterruptedException {
        // 线程不安全！
        final Integer[] cs = {0};
        int numThreads = 10;
        int numIncrements = 1000;

        // 创建一个线程池，包含10个线程    
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // 每个线程对int进行1000次增量操作  
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < numIncrements; j++) {
                    cs[0] = cs[0] + 1;
//                    System.out.println(cs[0]);
                    log.info(String.valueOf(cs[0]));
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待线程池执行结束  

        // 输出最终的值    
        log.info("线程不安全原子的值: " + cs[0]);
//        System.out.println("线程不安全原子的值: " + cs[0]);
    }
    
    @Test
    public void cs5() throws InterruptedException {
        int numThreads = 10000;
        int numIncrements = 1000;
        cs_entity cs_entity = new cs_entity();
        // 创建一个线程池，包含10个线程    
        ExecutorService executorService = Executors.newFixedThreadPool(numIncrements);

        // 测试原子引用-数据模型更新操作
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(new UpdateThread(cs_entity));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待线程池执行结束  
        
        // 检查sharedEntity的值是否被正确地更新  
//        assert 233==cs_entity.getAtomicRef().get();
    }
    @Test
    public void cs6() throws InterruptedException {
        int numThreads = 1000000;
        int numIncrements = 1000;
        cs_entity2 cs_entity2 = new cs_entity2();
        // 创建一个线程池，包含10个线程    
        ExecutorService executorService = Executors.newFixedThreadPool(numIncrements);

        // 测试原子引用-数据模型更新操作
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(()->{
                new UpdateThread2(cs_entity2);
                assert 233==cs_entity2.getI();
            });
        }

        executorService.shutdown();
//        executorService.awaitTermination(10, TimeUnit.SECONDS);// 等待10s线程池执行结束  
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);// 等完
        // 检查sharedEntity的值是否被正确地更新  
//        assert 233==cs_entity.getAtomicRef().get();
    }
    @Test
    public void cs7(){
        AtomicReference<Integer> atomicRef = new AtomicReference<>(0);
        // compareAndSet 如果原来的值是expected，则将其修改为updated，并返回true；否则返回false。
        // 并发编程技术。其作用是安全地比较并设置一个线程中的变量的值。
        log.info(atomicRef.compareAndSet(0, 1)+"\t"+atomicRef.get());
        log.info(atomicRef.compareAndSet(1, 2)+"\t"+atomicRef.get());
        log.info(atomicRef.compareAndSet(0, 2)+"\t"+atomicRef.get());
//        System.out.println(atomicRef.compareAndSet(0, 1)+"\t"+atomicRef.get());
//        System.out.println(atomicRef.compareAndSet(1, 2)+"\t"+atomicRef.get());
//        System.out.println(atomicRef.compareAndSet(0, 2)+"\t"+atomicRef.get());
    }
}
