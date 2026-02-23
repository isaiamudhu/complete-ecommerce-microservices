package com.ecommerce.inventory.event;

import java.io.Serializable;

public class OrderEvent implements Serializable {

    private Long orderId;
    private String productName;
    private int quantity;
    private double price;

    public OrderEvent() {}

    public OrderEvent(Long orderId, String productName, int quantity, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getOrderId() { return orderId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
