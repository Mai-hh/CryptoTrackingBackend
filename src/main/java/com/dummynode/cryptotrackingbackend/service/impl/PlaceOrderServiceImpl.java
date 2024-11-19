package com.dummynode.cryptotrackingbackend.service.impl;

import com.dummynode.cryptotrackingbackend.controller.PlaceOrderController;
import com.dummynode.cryptotrackingbackend.entity.dto.OrderDTO;
import com.dummynode.cryptotrackingbackend.entity.model.TransactionBuy;
import com.dummynode.cryptotrackingbackend.entity.model.TransactionSell;
import com.dummynode.cryptotrackingbackend.entity.model.User;
import com.dummynode.cryptotrackingbackend.repository.TransactionBuyRepository;
import com.dummynode.cryptotrackingbackend.repository.TransactionSellRepository;
import com.dummynode.cryptotrackingbackend.repository.UserRepository;
import com.dummynode.cryptotrackingbackend.service.PlaceOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(PlaceOrderServiceImpl.class);
    @Autowired
    private TransactionSellRepository transactionSellRepository;

    @Autowired
    private TransactionBuyRepository transactionBuyRepository;
    @Override
    @Transactional
    public void buy(OrderDTO orderDTO) {
        logger.info("buy service");
        Optional<User> user = userRepository.findByUserId(orderDTO.getUserId());
        if(user != null){
            logger.info("user found");
        }
        TransactionBuy transactionBuy = new TransactionBuy();
        transactionBuy.setUser(user.orElse(null));
        transactionBuy.setSymbol(orderDTO.getSymbol());
        transactionBuy.setDealPrice(orderDTO.getPrice());
        transactionBuy.setQuantity(orderDTO.getQuantity());
        transactionBuy.setCreatedAt(LocalDateTime.now());
        transactionBuy.setModifiedAt(LocalDateTime.now());
        transactionBuyRepository.save(transactionBuy);
    }
    @Override
    @Transactional
    public void sell(OrderDTO orderDTO){
        logger.info("sell service");
        Optional<User> user = userRepository.findByUserId(orderDTO.getUserId());
        TransactionSell transactionSell = new TransactionSell();
        transactionSell.setUser(user.orElse(null));
        transactionSell.setSymbol(orderDTO.getSymbol());
        transactionSell.setDealPrice(orderDTO.getPrice());
        transactionSell.setQuantity(orderDTO.getQuantity());
        transactionSell.setCreatedAt(LocalDateTime.now());
        transactionSell.setModifiedAt(LocalDateTime.now());
        transactionSellRepository.save(transactionSell);
    }
}
