package com.jiaty.demo.asyncThread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-04-27 17:12
 **/

@Component
@Slf4j
public class MyAsyncConfigurer implements AsyncConfigurer {

    @SneakyThrows
    @Override
    public Executor getAsyncExecutor() {
        NetworkService networkService1 = new NetworkService(1001, 10);
        return networkService1.pool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("Exception message - " + throwable.getMessage());
            log.info("Method name - " + method.getName());
            for (Object param : objects) {
                log.info("Parameter value - " + param);
            }
        }
    }

    class NetworkService implements Runnable {
        private final ServerSocket serverSocket;
        private final ExecutorService pool;

        public NetworkService(int port, int poolSize)
                throws IOException {
            serverSocket = new ServerSocket(port);
            pool = Executors.newFixedThreadPool(poolSize);
        }

        @Override
        public void run() { // run the service
            try {
                for (; ; ) {
                    pool.execute(new Handler(serverSocket.accept()));
                }
            } catch (IOException ex) {
                pool.shutdown();
            }
        }
    }

    class Handler implements Runnable {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // read and service request on socket
        }
    }
}