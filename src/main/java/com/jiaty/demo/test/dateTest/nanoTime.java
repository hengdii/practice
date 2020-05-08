package com.jiaty.demo.test.dateTest;

/**
 * @program: practice
 * @description: System.nanoTime
 * @author: jiaty
 * @create: 2020-01-03 17:43
 **/

public class nanoTime {

    public static void main(String[] args) {
        /**
         * 返回正在运行的Java虚拟机的高分辨率时间源的当前值，以纳秒为单位。
         *
         * 此方法只能用于测量经过的时间，并且与系统或挂钟时间的任何其他概念无关。返回的值表示纳秒，因为某些固定的任意原点时间 （可能在将来，因此值可能为负）。
         *
         * 在Java虚拟机的实例中，所有对此方法的调用都使用相同的原点;其他虚拟机实例可能使用不同的来源。 此方法提供纳秒级精度，但不一定是纳秒级分辨率（即，值的变化频率） - 除了分辨率至少与currentTimeMillis（）的分辨率一样好之外，不做任何保证。
         *
         * 连续调用的差异超过大约292年（2^63纳秒）将无法正确计算由于数值溢出而导致的经过时间。 只有在计算在Java虚拟机的同一实例中获得的两个此类值之间的差异时，此方法返回的值才有意义。
         *
         * 例如，要测量某些代码执行所需的时间：
         *
         * long startTime = System.nanoTime（）; // ...正在测量的代码...... long estimatedTime = System.nanoTime（） -  startTime; 比较两个nanoTime值 long t0 = System.nanoTime（）; ... long t1 = System.nanoTime（）;
         *
         * 一个应该使用t1 - t0 <0，而不是t1 <t0，因为数字溢出的可能性.
         *
         * Returns：正在运行的Java虚拟机的高分辨率时间源的当前值，以纳秒为单位
         *
         */
        long startTime = System.nanoTime();


        /**
         * 返回正在运行的Java虚拟机的高分辨率时间源的当前值，以纳秒为单位。
         *
         * 此方法只能用于测量经过的时间，并且与系统或挂钟时间的任何其他概念无关。
         *
         */
        System.out.println(startTime);
        /**
         * 注意⚠️: System.nanoTime()的性能不如System.currentTimeMillis()
         *
         * System.currentTimeMillis()是使用GetSystemTimeAsFileTime方法实现的，该方法基本上只读取Windows维护的低分辨率时间值。根据所报告的信息，读取这个全局变量自然很快 - 大约6个周期。
         *
         * System.nanoTime()使用实现所述QueryPerformanceCounter/ QueryPerformanceFrequency API（如果可用的话，否则它返回currentTimeMillis*10^6)。 QueryPerformanceCounter(QPC)在这取决于它的运行在硬件上不同的方式实现。
         *      通常，其使用两可编程间隔计时器（PIT）或ACPI电源管理计时器（PMT），或CPU级别的时间戳计数器（TSC）访问PIT / PMT需要执行慢速I / O端口指令，因此QPC的执行时间大约为几微秒。
         *      100个时钟周期的顺序（从芯片读取TSC并将其转换为基于工作频率的时间值）
         */

    }


}