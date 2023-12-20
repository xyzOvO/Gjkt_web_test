package com.xyz66.thread;

import lombok.Synchronized;

public class TestLombok{
    static int i = 100;

    @Synchronized
    public static void sout(){
        if (i>0){
            i--;
            System.out.println("i值为："+i);
        }
    }

    static class Lombok extends Thread{
        @Override
        public void run() {
            while(i>0){
                sout();
            }
        }
    }

    public static void main(String[] args) {
        new Lombok().start();
        new Lombok().start();
        new Lombok().start();
    }
}
