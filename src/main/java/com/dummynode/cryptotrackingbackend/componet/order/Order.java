package com.dummynode.cryptotrackingbackend.componet.order;

public interface Order {

    OrderType getType();

    double getQuantity();

    double getPrice();

}
