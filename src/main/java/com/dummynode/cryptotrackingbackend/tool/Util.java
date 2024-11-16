/**
 * HuaiHao Mo
 */
package com.dummynode.cryptotrackingbackend.tool;

import com.dummynode.cryptotrackingbackend.entity.dto.CryptocurrencyDTO;
import com.dummynode.cryptotrackingbackend.entity.vo.CryptocurrencyVO;

import java.math.BigDecimal;

public class Util {

    public static class NumberFormatter {
        private static final String[] UNITS = {"", "K", "M", "B", "T"};
        private static final BigDecimal STEP = BigDecimal.valueOf(1000);

        public static String format(BigDecimal number) {
            if (number.compareTo(BigDecimal.ZERO) < 0) {
                return "-" + format(number.negate());
            }

            int unitIndex = 0;
            BigDecimal value = number;

            while (value.compareTo(STEP) >= 0 && unitIndex < UNITS.length - 1) {
                value = value.divide(STEP, 2, BigDecimal.ROUND_HALF_UP);
                unitIndex++;
            }

            // Format to one decimal place
            return String.format("%.1f%s", value, UNITS[unitIndex]);
        }
    }

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
