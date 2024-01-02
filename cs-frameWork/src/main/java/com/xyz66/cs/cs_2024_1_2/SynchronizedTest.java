package com.xyz66.cs.cs_2024_1_2;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/2 17:26
 */
public class SynchronizedTest {
    //静态方法加锁，对该类所有的实例化对象生效
    public synchronized static void suoStatic(){}
    public synchronized void suo() {
        System.out.println("实例化对象锁");
    }

    public void demo() {
        synchronized (this) {
            System.out.println("代码块锁");
        }
    }
    // 为代码块加锁，锁对象为我们创建的任意一个对象。不要使用非final的成员变量作为同步锁对象，
    // 因为非final成员变量可以被重新赋值，导致不同的线程使用不同的对象作为锁，达不到同步锁定的效果。
    private final Object lock = new Object();
    public void demo2(){
        synchronized (lock) {
            System.out.println("代码块锁+final作为成员变量");
        }
    }
}
