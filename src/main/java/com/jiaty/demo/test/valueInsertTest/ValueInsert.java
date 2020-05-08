package com.jiaty.demo.test.valueInsertTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: practice
 * @description: value值注入
 * @author: jiaty
 * @create: 2019-12-30 17:20
 **/
@Component
@Slf4j
public class ValueInsert {

    @Autowired
    private Config config;

    @Test
    public void Test(){
        log.info(config.getFailedretryTime());
    }

}