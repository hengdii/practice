package com.jiaty.demo.date20191105;

import java.math.BigDecimal;

/**
 * @program: Practice
 * @description: sku
 * @author: jiaty
 * @create: 2019-11-05 14:00
 **/


public class SkuItem {

    private BigDecimal unitPirce;

    private Integer quentity;

    @Override
    public String toString() {
        return "SkuItem{" +
                "unitPirce=" + unitPirce +
                ", quentity=" + quentity +
                '}';
    }

    public BigDecimal getUnitPirce() {
        return unitPirce;
    }

    public void setUnitPirce(BigDecimal unitPirce) {
        this.unitPirce = unitPirce;
    }

    public Integer getQuentity() {
        return quentity;
    }

    public void setQuentity(Integer quentity) {
        this.quentity = quentity;
    }
}