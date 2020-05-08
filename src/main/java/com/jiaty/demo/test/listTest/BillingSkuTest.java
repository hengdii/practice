package com.jiaty.demo.test.listTest;

import com.jiaty.demo.test.testModel.SkuItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Practice
 * @description: bigdecimal排序
 * @author: jiaty
 * @create: 2019-11-05 13:50
 **/

public class BillingSkuTest {

    public static void main(String[] args) {
        List<SkuItem> skuItems = new ArrayList<>();
        SkuItem skuItem1 = new SkuItem();
        SkuItem skuItem2 = new SkuItem();
        SkuItem skuItem3 = new SkuItem();
        SkuItem skuItem4 = new SkuItem();
        SkuItem skuItem5 = new SkuItem();
        skuItem1.setQuentity(1);
        skuItem1.setUnitPirce(new BigDecimal(6.9 + ""));
        skuItem2.setQuentity(2);
        skuItem2.setUnitPirce(new BigDecimal(3.9 + ""));
        skuItem3.setQuentity(1);
        skuItem3.setUnitPirce(new BigDecimal(6.7 + ""));
        skuItems.add(skuItem1);
        skuItems.add(skuItem2);
        skuItems.add(skuItem3);
        skuItem4.setQuentity(4);
        skuItem4.setUnitPirce(new BigDecimal(0.3 + ""));
        skuItem5.setQuentity(4);
        skuItem5.setUnitPirce(new BigDecimal(2 + ""));
        skuItems.add(skuItem4);
        skuItems.add(skuItem5);


        skuItems.sort((t, e) -> {
            BigDecimal skuPrice = t.getUnitPirce().multiply(BigDecimal.valueOf(t.getQuentity()));
            BigDecimal skuPrice1 = e.getUnitPirce().multiply(BigDecimal.valueOf(e.getQuentity()));
            int a = skuPrice.compareTo(skuPrice1);
            return a;
        });
//        for (int i = 0; i < skuItems.size(); i++) {
//            // 设定一个排序完成的标记
//            // 若为 true，则表示此次循环没有进行交换，即待排序列已经有序，排序已然完成
//            boolean success = true;
//            for (int j = 0; j < skuItems.size() - i - 1; j++) {
//                BigDecimal skuPrice = skuItems.get(j).getUnitPirce().multiply(BigDecimal.valueOf(skuItems.get(j).getQuentity()));
//                BigDecimal skuPrice1 = skuItems.get(j+1).getUnitPirce().multiply(BigDecimal.valueOf(skuItems.get(j+1).getQuentity()));
//                if (skuPrice.compareTo(skuPrice1) == 1) {
//                    Collections.swap(skuItems, j, j + 1);
//                    success = false;
//                }
//            }
//            if (success) {
//                break;
//            }
//            System.out.println("第" + (i + 1) + "轮后: " + skuItems);
//        }

        System.out.println(skuItems);
    }

}
