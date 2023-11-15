package org.example;


import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();

        Thread primero=new Thread(counter,"Primero");
        Thread segundo=new Thread(counter,"Segundo");
        primero.start();
        segundo.start();

        primero.join();
        segundo.join();

        System.out.println(counter.count);
    }

   static class Counter extends Thread{
        public AtomicInteger count=new AtomicInteger(0);
        public void run(){
            for (int i=0;i< 100_000_000;i++){
                count.addAndGet(1);
            }

        }
    }



}