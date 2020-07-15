package com.jiaty.demo.test.listTest;

import com.alibaba.fastjson.JSON;
import com.jiaty.demo.test.testModel.Person;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Practice
 * @description:
 * @author: Jiaty
 * @create: 2020-07-06 16:43
 **/

public class AddListTest {

    public static void main(String[] args) {

        Person p = new Person();

        p.setAge(1);
        p.setName("123");
        p.setPrice(BigDecimal.TEN);
        p.setSex(true);

        List<Person> personList = new ArrayList<>();
        personList.add(p);

        Person person = personList.get(0);
        Person p2 = new Person();
        BeanUtils.copyProperties(person,p2);
        p2.setPrice(BigDecimal.ONE);
        personList.add(p2);
        System.out.println(JSON.toJSONString(personList));

    }
}