package com.jiaty.demo.test.nullPointerExceptionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Practice
 * @description: 测试null
 * @author: jiaty
 * @create: 2019-11-28 13:27
 **/

public class Null {

    public static void main(String[] args) {
        List<NullTest> nullTests = new ArrayList<>();
        NullTest n1 = new NullTest();
        NullTest n2 = new NullTest();
        NullTest n3 = new NullTest();
        n1.setAge(10);
        n1.setName("10");
        n2.setAge(10);
        n2.setName("10");
        n2.setSex("男");
        n3.setAge(30);
        n3.setName("30");
        n3.setSex("女");
        nullTests.add(n1);
        nullTests.add(n2);
        nullTests.add(n3);
        nullTests.stream().filter(n -> n.getSex().equals("女")).map(n -> {
            NullTest n4 = new NullTest();
            n4.setSex(n.getSex());
            n4.setName(n.getName());
            n4.setAge(n.getAge());
            System.out.println(n.toString());
            return n;
        }).collect(Collectors.toList());
//        n1.getSex() == "女";
//        n1.getSex() != "女";
//        "女".equals(n1.getSex());
//       上面这三种都不报空指针
    }


    public static class NullTest {

        private String name;

        private Integer age;

        private String sex;

        @Override
        public String toString() {
            return "NullTest{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}