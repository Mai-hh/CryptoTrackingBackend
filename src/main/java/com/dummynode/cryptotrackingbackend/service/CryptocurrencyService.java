/**
 * HuaiHao Mo
 */
package com.dummynode.cryptotrackingbackend.service;

import com.dummynode.cryptotrackingbackend.entity.vo.CryptocurrencyVO;
import com.dummynode.cryptotrackingbackend.entity.vo.wrapper.CryptocurrencyVOWrapper;

import java.util.List;

public interface CryptocurrencyService {

    ApiResponse<List<CryptocurrencyVOWrapper>> getLatestCryptocurrencies();
}
