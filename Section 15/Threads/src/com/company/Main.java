package com.company;

import static com.company.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        // you can extend Thread
        Thread anotherThread = new AnotherThread(){
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from Anonymous method");
            }
        };
        anotherThread.start();

        // you can also implement Runnable
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from my anonymous class's implementation of MyRunnable.");
            }
        });
        myRunnableThread.start();


    }
}
