package com.xyz66.cs.cs2023年11月24日;

import java.util.concurrent.atomic.AtomicReference;

class UpdateThread implements Runnable {  
    private cs_entity entity;  
      
    public UpdateThread(cs_entity entity) {  
        this.entity = entity;  
    }  
      
    @Override  
    public void run() {  
        // 对entity进行值的更新操作
        AtomicReference<Integer> atomicReferenceTest = new AtomicReference<>(233);
        entity.setAtomicRef(atomicReferenceTest);
        System.out.println(entity.getAtomicRef().get());
    }  
}  
