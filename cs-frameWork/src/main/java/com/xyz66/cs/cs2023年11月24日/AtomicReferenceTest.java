package com.xyz66.cs.cs2023年11月24日;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;  
  
public class AtomicReferenceTest {  
    // 原子引用,保证线程安全
    private static AtomicReference<Integer> atomicRef = new AtomicReference<>(0);  
//    private static List<Integer> atomicRef = new ArrayList<>(0);
  
    @Test
    public void cs1(){  
        Thread t1 = new Thread(() -> {  
            for (int i = 0; i < 1000; i++) {  
                atomicRef.set(i);  
                System.out.println("线程1设置的值为：" + atomicRef.get());  
            }  
        });  
  
        Thread t2 = new Thread(() -> {  
            for (int i = 0; i < 1000; i++) {  
                atomicRef.set(i);  
                System.out.println("线程2设置的值为：" + atomicRef.get());  
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
  
        System.out.println("最终的值为：" + atomicRef.get()); // 打印最终的值  
    }  
}
