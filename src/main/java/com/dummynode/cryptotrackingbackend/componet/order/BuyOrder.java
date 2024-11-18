package com.dummynode.cryptotrackingbackend.componet.order;

public class BuyOrder implements Order {
    private final double quantity;
    private final double price;

    public BuyOrder(double quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public OrderType getType() {
        return OrderType.BUY;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    // 其他买入订单特定的方法...
}