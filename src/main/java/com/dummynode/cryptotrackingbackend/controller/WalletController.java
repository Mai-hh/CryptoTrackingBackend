package com.dummynode.cryptotrackingbackend.controller;

import com.dummynode.cryptotrackingbackend.entity.dto.OrderDTO;
import com.dummynode.cryptotrackingbackend.service.PlaceOrderService;
import com.dummynode.cryptotrackingbackend.service.WalletService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/users")
public class WalletController {
        private static final Logger logger = LoggerFactory.getLogger(com.dummynode.cryptotrackingbackend.controller.WalletController.class);
        @Autowired
        WalletService walletService;
        @PostMapping("/wallet")
        public ResponseEntity<Void> PlaceOrder(@RequestBody OrderDTO orderDTO, HttpServletRequest request) {

            if (orderDTO.getType() == 0) {
                logger.info("order type: sell");
                walletService.sell(orderDTO);
            } else {
                logger.info("order type: buy");
                walletService.buy(orderDTO);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
