package com.jiaty.demo.test.retryTest;

import com.jiaty.demo.service.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: practice
 * @description: 重试服务的测试
 * @author: jiaty
 * @create: 2019-12-26 15:20
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetryTest {

    @Autowired
    private RetryService retryService;

    private Logger logger = LoggerFactory.getLogger(RetryTest.class);

    @Test
    public void retryTest() {
        //int count = retryService.retry(-1);
        double a = 1.3213;
        double b = 0.1;
        retryService.devide(a,b);
        //logger.info("库存为：" + count);
    }
}