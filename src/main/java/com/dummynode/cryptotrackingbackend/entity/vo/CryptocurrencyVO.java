/**
 * HuaiHao Mo
 */
package com.dummynode.cryptotrackingbackend.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyVO {

    private String name;

    private String symbol;

    private Double price;

    private Double percentChange24h;

    private Double marketCap;

    private Double volume24h;

    private Long maxSupply;
}
