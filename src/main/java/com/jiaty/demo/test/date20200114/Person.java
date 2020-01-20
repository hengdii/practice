package com.jiaty.demo.test.date20200114;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-26 09:58
 **/

@Data
public class Person {

    private String name;

    private Integer Age;

    private Boolean flg;

    private BigDecimal price;
}