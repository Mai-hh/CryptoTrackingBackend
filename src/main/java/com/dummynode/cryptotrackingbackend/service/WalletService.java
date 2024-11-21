package com.dummynode.cryptotrackingbackend.service;

import com.dummynode.cryptotrackingbackend.entity.dto.OrderDTO;

public interface WalletService {
    void buy(OrderDTO orderDTO);
    void sell(OrderDTO orderDTO);
}
