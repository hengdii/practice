package com.jiaty.demo.test.tryCatchTest;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @program: practice
 * @description: try with source
 * @author: jiaty
 * @create: 2020-01-07 11:54
 **/

public class TryWithSource {

    public void tryTest() {
        try {
            String s = "";
            OutputStream outputStream = new FileOutputStream(s);
            try {
                throw new RuntimeException();
            }finally {
                outputStream.close();
            }
        }catch (Exception e){

        }finally {

        }
    }


}