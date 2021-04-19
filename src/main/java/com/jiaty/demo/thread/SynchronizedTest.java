package com.jiaty.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2021-04-13 23:43
 **/

@Slf4j
public class SynchronizedTest {

    static Thread t1;

    static Thread t2;

    static Thread t3;

    static int loopFlag = 19;


    public static void main(String[] args) {
        List<A> list = new ArrayList<>();


        t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < loopFlag; i++) {
                    A a = new A();
                    list.add(a);
                    synchronized (a) {
                        log.debug(i + " " + ClassLayout.parseInstance(a).toPrintable(a));
                    }
                }

                log.debug("==============t2=========");
                LockSupport.unpark(t2);
            }
        };


    }

    static class A {
        A() {
        }
    }

}