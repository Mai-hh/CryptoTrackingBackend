package com.dummynode.cryptotrackingbackend.componet.order;

public class SellOrder implements Order {
    private final double quantity;
    private final double price;

    public SellOrder(double quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public OrderType getType() {
        return OrderType.SELL;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    // 其他卖出订单特定的方法...
}