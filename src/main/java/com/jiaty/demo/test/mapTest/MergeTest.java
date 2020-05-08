package com.jiaty.demo.test.mapTest;

import com.alibaba.fastjson.JSON;
import com.jiaty.demo.test.testModel.GiftModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Practice
 * @description: map里面的merge
 * @author: Jiaty
 * @create: 2020-05-06 11:35
 **/

public class MergeTest {

    public static void main(String[] args) {
        List<GiftModel> giftModels = new ArrayList<>();
        GiftModel giftModel = new GiftModel();
        giftModel.setGiftId("1");
        giftModel.setQuantity(1);
        GiftModel giftModel1 = new GiftModel();
        giftModel1.setGiftId("1");
        giftModel1.setQuantity(1);
        GiftModel giftModel2 = new GiftModel();
        giftModel2.setGiftId("1");
        giftModel2.setQuantity(1);
        GiftModel giftModel3 = new GiftModel();
        giftModel3.setGiftId("1");
        giftModel3.setQuantity(1);
        GiftModel giftModel4 = new GiftModel();
        giftModel4.setGiftId("2");
        giftModel4.setQuantity(2);
        GiftModel giftModel5 = new GiftModel();
        giftModel5.setGiftId("2");
        giftModel5.setQuantity(2);
        GiftModel giftModel6 = new GiftModel();
        giftModel6.setGiftId("3");
        giftModel6.setQuantity(3);
        GiftModel giftModel7 = new GiftModel();
        giftModel7.setGiftId("3");
        giftModel7.setQuantity(3);
        GiftModel giftModel8 = new GiftModel();
        giftModel8.setGiftId("4");
        giftModel8.setQuantity(4);
        //id = null  result:{null:10,"1":4,"2":4,"3":6,"4":4}
        GiftModel giftModel9 = new GiftModel();
        giftModel9.setQuantity(10);
        //quantity = null result: java.lang.NullPointerException
        GiftModel giftModel10 = new GiftModel();
        giftModel10.setGiftId("10");

        giftModels.add(giftModel);
        giftModels.add(giftModel1);
        giftModels.add(giftModel2);
        giftModels.add(giftModel3);
        giftModels.add(giftModel4);
        giftModels.add(giftModel5);
        giftModels.add(giftModel6);
        giftModels.add(giftModel7);
        giftModels.add(giftModel8);
        giftModels.add(giftModel9);
        giftModels.add(giftModel10);

        Map<String, Integer> quantityMap = new HashMap<>();
        giftModels.forEach(gift -> quantityMap.merge(gift.getGiftId(), gift.getQuantity(), Integer::sum));

        System.out.println(JSON.toJSONString(quantityMap));
    }

}