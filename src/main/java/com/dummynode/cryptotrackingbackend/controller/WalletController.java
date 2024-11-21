package com.dummynode.cryptotrackingbackend.controller;

import com.dummynode.cryptotrackingbackend.entity.dto.OrderDTO;
import com.dummynode.cryptotrackingbackend.entity.dto.UserDTO;
import com.dummynode.cryptotrackingbackend.entity.vo.BalanceVO;
import com.dummynode.cryptotrackingbackend.entity.vo.WalletVO;
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

import java.util.List;

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
        @PostMapping("/wallet/info")
        public ResponseEntity<List<WalletVO>> GetWallet(@RequestBody UserDTO userDTO, HttpServletRequest request) {

            List<WalletVO> res = walletService.getWallet(userDTO.getUserId());

            return new ResponseEntity<>(res,HttpStatus.OK);
        }

        @PostMapping("/balance")
        public ResponseEntity<BalanceVO> GetBalance(@RequestBody UserDTO userDTO, HttpServletRequest request) {

            BalanceVO res = walletService.getBalance(userDTO.getUserId());

            return new ResponseEntity<>(res,HttpStatus.OK);
        }
    }

