package com.cg;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("downloading file " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download Complete " + Thread.currentThread().getName());

    }
}
