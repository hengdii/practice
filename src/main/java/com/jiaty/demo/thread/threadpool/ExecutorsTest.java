package com.jiaty.demo.thread.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: practice
 * @description: 线程池中某线程抛出异常
 * @author: Jiaty
 * @create: 2021-04-22 00:05
 **/

public class ExecutorsTest {

    private static ThreadPoolTaskExecutor buildThreadPoolExecutor() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setThreadNamePrefix("线程池中线程异常");
        executorService.setCorePoolSize(5);
        executorService.setMaxPoolSize(10);
        executorService.setQueueCapacity(10000);
        executorService.setKeepAliveSeconds(30);
//        executorService.setRejectedExecutionHandler();
        executorService.initialize();
        return executorService;
    }


    private static void sayHi(String name) {
        String printStr = "[Thread-name:" + Thread.currentThread().getName() + ",执行方式" + name + "]";
        System.out.println(printStr);
        throw new RuntimeException(printStr + "我异常啦！哈哈哈哈");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolTaskExecutor executor = buildThreadPoolExecutor();

        Future<?> submit = executor.submit(() -> sayHi("submit"));
//        System.out.println(submit.get());

        executor.execute(()->sayHi("executor"));

    }
}