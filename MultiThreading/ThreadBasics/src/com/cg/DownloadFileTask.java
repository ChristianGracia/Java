package com.cg;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("downloading file " + Thread.currentThread().getName());

    }
}
