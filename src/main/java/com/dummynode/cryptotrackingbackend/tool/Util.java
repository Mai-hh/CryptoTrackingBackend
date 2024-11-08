package com.dummynode.cryptotrackingbackend.tool;

import com.dummynode.cryptotrackingbackend.entity.dto.CryptocurrencyDTO;
import com.dummynode.cryptotrackingbackend.entity.vo.CryptocurrencyVO;

public class Util {

    public static CryptocurrencyVO toCryptocurrencyVO(CryptocurrencyDTO.Cryptocurrency cryptocurrency) {
        return new CryptocurrencyVO(
                cryptocurrency.getName(),
                cryptocurrency.getSymbol(),
                cryptocurrency.getQuote().getUsd().getPrice(),
                cryptocurrency.getQuote().getUsd().getPercentChange24h(),
                cryptocurrency.getQuote().getUsd().getMarketCap(),
                cryptocurrency.getQuote().getUsd().getVolume24h(),
                cryptocurrency.getMaxSupply()
        );
    }

}
