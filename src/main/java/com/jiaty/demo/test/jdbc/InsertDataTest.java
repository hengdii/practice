package com.jiaty.demo.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @program: Practice
 * @description: 插入数据
 * @author: Jiaty
 * @create: 2020-06-17 17:13
 **/

public class InsertDataTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        // ================ 插入数据 ================

        Connection conn = null;

        Statement st = null;


        try {
            // 1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2、创建连接
            String url = "jdbc:mysql://192.168.2.26:3306/payment_gateway";
            String user = "devdb";
            String password = "Jhd@devdb1";
            conn = DriverManager.getConnection(url, user, password);

            // 3、创建sql语句
//            String sql = "insert into stu values(1, 'zjj', 20)";
            for (int i = 1; i < 10001; i++) {
                String sql = "insert into `settlement_result`(`transaction_type`,`detail_order_num`,`transaction_flows`,`transaction_id`,`settle_order_number`,`settle_flows_number`,`settle_source`,`settle_attach`,`transaction_amount`,`settlement_amount`,`fee_scale`,`settlement_type`,`collecting_company`,`payee_account_id`,`settle_type`,`income_type`,`settle_time`,`create_time`,`settlement_detail_num`,`status`)\n" +
                        "values('B','200612101001643','30320061319552104','2006121909046623220277653','39520061319553905','395100061319554101',3,1,0.02,0.02,0.00,1,'金莉','1020032412064815',9,5,'2020-06-13 19:55:24','2020-06-13 19:55:25',i,1);\n";
                st = conn.createStatement();

                // 4、执行语句
                int row = st.executeUpdate(sql);
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5、释放
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

}