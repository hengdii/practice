package com.jiaty.demo.test.valueInsertTest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: practice
 * @description: 动态配置
 * @author: jiaty
 * @create: 2019-12-30 17:50
 **/

@Component
@Data
public class Config {

    @Value("${failedretryTime}")
    public String failedretryTime;


}