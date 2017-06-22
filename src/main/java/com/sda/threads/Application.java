package com.sda.threads;

/**
 * Created by bartosz on 22.06.2017.
 */
public class Application {
    public static void main(String[] args) {
        MyTask myTask = new MyTask(" one ");
        MyTask myTask2 = new MyTask(" two ");
        MyTask myTask3 = new MyTask(" three ");


        Thread thread = new Thread(myTask);
        Thread thread2 = new Thread(myTask2);
        Thread thread3 = new Thread(myTask3);

        //wykonuje sie asychronicznie - czeka i uruchami wszystko naraz
        thread.start();
        thread2.start();
        thread3.start();

        //wykonuje sie synchronicznie - uruchami i czek , znowu czek i uruchamia
        // thread.run();
        // thread2.run();
        // thread3.run();


    }
}
