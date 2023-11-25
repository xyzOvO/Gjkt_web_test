package com.xyz66.cs.cs2023年11月24日;

/**
 * @author xyz66 Email:2910223554@qq.com
 * @since 2023/11/25 13:05
 */
public class UpdateThread2 implements Runnable{
    private cs_entity2 entity2;

    public UpdateThread2(cs_entity2 entity2) {
        this.entity2 = entity2;
    }

    @Override
    public void run() {
        // 对entity进行值的更新操作
        entity2.setI(233);
        System.out.println(entity2.getI());
    }
}
