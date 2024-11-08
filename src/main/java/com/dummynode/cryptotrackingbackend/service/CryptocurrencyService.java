package com.dummynode.cryptotrackingbackend.service;

import com.dummynode.cryptotrackingbackend.entity.vo.CryptocurrencyVO;

import java.util.List;

public interface CryptocurrencyService {

    List<CryptocurrencyVO> getLatestCryptocurrencies();
}
