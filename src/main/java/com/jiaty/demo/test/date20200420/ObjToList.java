package com.jiaty.demo.test.date20200420;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: Practice
 * @description: Obj转成List
 * @author: Jiaty
 * @create: 2020-04-20 12:22
 **/

public class ObjToList {


    private static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return result;
    }



    private static Map<String,Object> getList(){
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge("11");
        student.setName("小明");
        student.setSex(false);

        Student student1 = new Student();
        student1.setAge("12");
        student1.setName("小明");
        student1.setSex(false);
        Student student2 = new Student();
        student2.setAge("13");
        student2.setName("小明");
        student2.setSex(false);
        Student student3 = new Student();
        student3.setAge("14");
        student3.setName("小明");
        student3.setSex(false);

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("key",students);
        return map;
    }


    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
//        Object obj = getList();
//        List<Student> students = (List<Student>)obj;
//        List<Student> students = castList(obj, Student.class);
        Map<String, Object> list = getList();
        Object key = list.get("key");
        List<Student> students = castList(key,Student.class);
        List<Student> collect = students.stream().filter(Student::isSex).collect(Collectors.toList());
        System.out.println(collect.size());
//        for (Student student : students) {
//            s.add(student.getName());
//        }
//        System.out.println(collect.size());
//        System.out.println(s.toString());
    }
}