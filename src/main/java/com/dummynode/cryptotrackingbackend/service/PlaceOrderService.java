package com.dummynode.cryptotrackingbackend.service;

import com.dummynode.cryptotrackingbackend.controller.PlaceOrderController;
import com.dummynode.cryptotrackingbackend.entity.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface PlaceOrderService {
    void buy(OrderDTO orderDTO);
    void sell(OrderDTO orderDTO);
}
