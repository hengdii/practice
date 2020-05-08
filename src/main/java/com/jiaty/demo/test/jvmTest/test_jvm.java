package com.jiaty.demo.test.jvmTest;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;

/**
 * @program: Practice
 * @description: jvm相关
 * @author: jiaty
 * @create: 2019-07-29 19:23
 **/

public class test_jvm {


    public static void main(String[] args) {
        //堆内存  对象，数组
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println("jvm.heap.init is " + (heapMemoryUsage.getInit()));
        System.out.println("jvm.heap.used is " + (heapMemoryUsage.getUsed()));
        System.out.println("jvm.heap.committed is " + (heapMemoryUsage.getCommitted()));
        System.out.println("jvm.heap.max is " + (heapMemoryUsage.getMax()));
        //非堆内存  方法区  类信息，静态变量
        MemoryUsage nonHeapMemoryUsage = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        System.out.println("jvm.nonheap.init is " + (nonHeapMemoryUsage.getInit()));
        System.out.println("jvm.nonheap.used is " + (nonHeapMemoryUsage.getUsed()));
        System.out.println("jvm.nonheap.committed is " + (nonHeapMemoryUsage.getCommitted()));
        System.out.println("jvm.nonheap.max is " + (nonHeapMemoryUsage.getMax()));


        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            final String kind = pool.getType() == MemoryType.HEAP ? "heap" : "nonheap";
            final MemoryUsage usage = pool.getUsage();
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".init is " + usage.getInit());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".used is " + usage.getUsed());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".committed is " + usage.getCommitted());
            System.out.println("kind is " + kind + ", pool name is " + pool.getName() + ", jvm." + pool.getName() + ".max is " + usage.getMax());
        }

    }

}