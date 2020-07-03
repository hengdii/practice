package com.jiaty.demo.serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @program: Practice
 * @description: 对transient这个序列化的关键字的test
 * @author: Jiaty
 * @create: 2020-07-01 15:58
 **/
@Slf4j
public class TransientTest {

    public static void main(String[] args) {
        try {
            Rectangle rectangle = new Rectangle(5, 4);
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("rectangle"));
            outputStream.writeObject(rectangle);
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("rectangle"));
            Rectangle rectangle1 = (Rectangle) inputStream.readObject();
            rectangle1.setArea();
            System.out.println("原来的 : " + rectangle);
            System.out.println("现在的 : " + rectangle1);
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }

    }


    @Data
    static class Rectangle implements Serializable {

        private Integer length;

        private Integer width;

        private transient Integer area;

        Rectangle(Integer length, Integer width) {
            this.length = length;
            this.width = width;
            this.area = length * width;
        }

        public void setArea() {
            this.area = this.length * this.width;
        }

    }
}