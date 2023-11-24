package com.xyz66.cs.cs2023年11月24日;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/24 17:00
 */
public class cs_Thread implements Runnable{
    private AtomicReference<Integer> cs;
    cs_Thread(AtomicReference<Integer> cs){
        this.cs = cs;
    }
    @Override
    public void run() {
        // 1.创建一个AtomicReference对象
        for (int i = 0; i < 10000; i++) {
            // 2.获取原子变量的值
            int get = cs.get();
            // 3.将原子变量的值加1
            int update = get + 1;
            // 4.将原子变量的值更新为update
            cs.set(update);
            System.out.println(cs.get());
//            atomicReference.compareAndSet(get, update);
        }
    }
}
