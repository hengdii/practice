package com.jiaty.demo.test.listTest;


import com.jiaty.demo.test.testModel.BillingOrderItems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jhd-fcs-api
 * @description:
 * @author: jiaty
 * @create: 2019-10-23 18:05
 **/

public class BillingMainTest {


    public static void main(String[] args) {
        List<BillingOrderItems> reduceItems = new ArrayList<>();
        BillingOrderItems items1 = new BillingOrderItems();
        BillingOrderItems items2 = new BillingOrderItems();
        BillingOrderItems items3 = new BillingOrderItems();
        BillingOrderItems items4 = new BillingOrderItems();

        items1.setQuantity(2);
        items1.setUnitPrice(BigDecimal.valueOf(100));

        reduceItems.add(items1);
        reduceItems.forEach(l -> {
            String s = l.toString();
            System.out.println(s + "---------------------");
        });


        //把该商品组金额最大的sku，排除出Items
        reduceItems.sort((t, e) -> {
            int a = t.getQuantity() * (t.getUnitPrice().intValue()) - e.getQuantity() * (e.getUnitPrice().intValue());
            return a;
        });
        System.out.println(reduceItems.size());

        BillingOrderItems items = reduceItems.get(reduceItems.size() - 1);
        reduceItems.remove(reduceItems.size() - 1);
        BigDecimal jia = BigDecimal.ZERO;

        System.out.println(items + "最后一位");
        reduceItems.forEach(l -> {
            String s = l.toString();
            System.out.println(s + "last");
        });
        for (BillingOrderItems item : reduceItems) {
            jia = jia.add(BigDecimal.TEN);
        }
        System.out.println(jia);
    }
}