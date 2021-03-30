package com.jiaty.demo.lock;

import com.jiaty.demo.design.patterns.singleton.SingletonFactory;
import lombok.SneakyThrows;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * @program: practice
 * @description:
 * @author: Jiaty
 * @create: 2021-03-25 11:13
 **/

public class SynchronizedTest {

    /**
     * 这样的尝试是不可取的
     *
     * @param args
     */
    public static void main(String[] args) {
//        Thread thread1 = new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                synchronized (Person.class) {
//                    System.out.println("person 锁住了");
//                }
//                Thread.sleep(10000);
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Person person = new Person();
//                person.setName("12312312");
//                System.out.println(person.toString());
//            }
//        });
//        thread1.start();
//        thread2.start();
//
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor()

        Thread thread3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Person instance = SingletonFactory.getInstance(Person.class);
                synchronized (Person.class) {
                    System.out.println("person 锁住了");
                    instance.setName("33333");
                    System.out.println(instance.toString());
                }
                Thread.sleep(10000);
            }
        });


        Thread thread4 = new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                Person instance = SingletonFactory.getInstance(Person.class);
                instance.setName("12312312");
                System.out.println(instance.toString());
//                Thread.sleep(10000);
            }
        });

        thread3.start();
        thread4.start();

    }


}