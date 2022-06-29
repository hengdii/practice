package com.jiaty.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author tengyu5
 * @date 2022/06/28
 **/

public class CompletionServiceExceptionTest {

    public static void test() throws InterruptedException, ExecutionException {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        service.submit(() -> "Hello World--"+Thread.currentThread().getName());
        service.take().get();
    }

    /**
     *  错误写法，会导致OOM
     */
    public static void test1(){
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        service.submit(() -> "Hello World--"+Thread.currentThread().getName());
    }

}