package com.sda.threads;

/**
 * Created by bartosz on 22.06.2017.
 */
public class MyTask implements  Runnable {


    private  String name;

    public MyTask(String name) { this.name = name; }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello World form" + name + "thread ");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
