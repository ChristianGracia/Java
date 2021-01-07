package com.cg;

public class Threads {

    public static void show() {

        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            // this is making the main thread freeze until the other thread finishes
            // don't want to do this in real applications
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("File is ready to be scanned");

    }

}
