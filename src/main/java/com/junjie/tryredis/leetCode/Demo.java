package com.junjie.tryredis.leetCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("Thread is running...:{}", Thread.currentThread().getName());

            try {
                Thread.sleep(5000); // 模拟耗时操作
            } catch (InterruptedException e) {
                log.error("Thread was interrupted during sleep.", e);
                Thread.currentThread().interrupt(); // 重新设置中断状态
            }

        }, "DemoThread");

        thread.start();

        thread.wait();

        Thread.sleep(1000);

        thread.notify();
    }


}
