package com.jiaty.demo.test.retryTest;

/**
 * @program: Practice
 * @description: 重试机制
 * @author: jiaty
 * @create: 2019-11-15 14:27
 **/

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RetryProcess {
    //重试的次数
    int value() default 1;
}