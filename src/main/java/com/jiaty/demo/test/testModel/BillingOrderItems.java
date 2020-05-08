package com.jiaty.demo.test.testModel;

import java.math.BigDecimal;

/**
 * @program: jhd-fcs-api
 * @description: 计费接受订单商品详情
 * @author: jiaty
 * @create: 2019-10-17 19:41
 **/


public class BillingOrderItems {

    /**
     * skuId
     */
    private String skuId;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getItemChannel() {
        return itemChannel;
    }

    @Override
    public String toString() {
        return "BillingOrderItems{" +
                "skuId='" + skuId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", ownerId='" + ownerId + '\'' +
                ", isGift=" + isGift +
                ", purchasePrice=" + purchasePrice +
                ", itemChannel='" + itemChannel + '\'' +
                '}';
    }

    public void setItemChannel(String itemChannel) {
        this.itemChannel = itemChannel;
    }

    /**
     * sku个数
     */
    private Integer quantity;
    /**
     * sku单价
     */
    private BigDecimal unitPrice;
    /**
     * 货主id
     */
    private String ownerId;

    /**
     * 商品是否是赠品(false不是赠品 true:是赠品 ，默认false)
     */
    private boolean isGift;
    /**
     * 采购价
     */
    private BigDecimal purchasePrice;
    /**
     * 自营标示
     */
    private String itemChannel;
}