package com.jiaty.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @program: practice
 * @description: Spring的重试机制
 * @author: jiaty
 * @create: 2019-12-25 15:52
 **/

@Service
@Slf4j
public class RetryService {
    /**
     * Spring boot使用spring retry重试机制
     * 当我们调用接口的时候由于网络原因可能失败，再尝试就成功了，这就是重试机制。非幂等的情况下要小心使用重试。
     */

    /**
     * tips：幂等性
     * HTTP/1.1中对幂等性的定义是：一次和多次请求某一个资源对于资源本身应该具有同样的结果（网络超时等问题除外）。也就是说，其任意多次执行对资源本身所产生的影响均与一次执行的影响相同。
     */

    private Logger logger = LoggerFactory.getLogger(RetryService.class);

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 2))
    public void devide(double a, double b){
        logger.info("开始进行除法运算");
        if (b == 0) {
            throw new RuntimeException();
        }
        logger.info("{} / {} = {}", a, b, a / b);
    }

    /**
     * @Retryable注解:
     * value: 抛出指定异常才会重试
     * include：和value一样，默认为空，当exclude也为空时，默认所以异常
     * exclude：指定不处理的异常
     * maxAttempts：最大重试次数，默认3次
     * backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L；multiplier（指定延迟倍数）
     *
     * @Recover注解：
     * 当重试达到指定次数时候该注解的方法将被回调
     * 发生的异常类型需要和@Recover注解的参数一致
     * @Retryable注解的方法不能有返回值，不然@Recover注解的方法无效
     *
     */

    @Recover
    public void recover() {
        logger.error("被除数不能为0");
    }


    public void  TestMain(){
        log.info("1231231234123213");
    }

}