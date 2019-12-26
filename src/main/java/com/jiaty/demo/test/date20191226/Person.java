package com.jiaty.demo.test.date20191226;

import lombok.Builder;
import lombok.Data;

/**
 * @program: practice
 * @description:
 * @author: jiaty
 * @create: 2019-12-26 09:58
 **/

@Data
@Builder
public class Person {

    private String name;

    private Integer Age;

    private Boolean flg;
}