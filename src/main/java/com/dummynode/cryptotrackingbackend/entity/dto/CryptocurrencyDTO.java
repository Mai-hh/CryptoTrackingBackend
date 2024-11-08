package com.dummynode.cryptotrackingbackend.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CryptocurrencyDTO {
    @JsonProperty("status")
    private Status status;
    @JsonProperty("data")
    private List<Cryptocurrency> data;

    @Data
    public static class Status {
        @JsonProperty("timestamp")
        private String timestamp;
        @JsonProperty("error_code")
        private int errorCode;
        @JsonProperty("error_message")
        private Object errorMessage;
        @JsonProperty("elapsed")
        private int elapsed;
        @JsonProperty("credit_count")
        private int creditCount;
        @JsonProperty("notice")
        private Object notice;
        @JsonProperty("total_count")
        private int totalCount;
    }

    @Data
    public static class Cryptocurrency {
        @JsonProperty("id")
        private int id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("symbol")
        private String symbol;
        @JsonProperty("slug")
        private String slug;
        @JsonProperty("num_market_pairs")
        private int numMarketPairs;
        @JsonProperty("date_added")
        private String dateAdded;
        @JsonProperty("tags")
        private List<String> tags;
        @JsonProperty("max_supply")
        private Long maxSupply;
        @JsonProperty("circulating_supply")
        private double circulatingSupply;
        @JsonProperty("total_supply")
        private double totalSupply;
        @JsonProperty("platform")
        private Platform platform;
        @JsonProperty("cmc_rank")
        private int cmcRank;
        @JsonProperty("self_reported_circulating_supply")
        private Double selfReportedCirculatingSupply;
        @JsonProperty("self_reported_market_cap")
        private Double selfReportedMarketCap;
        @JsonProperty("tvl_ratio")
        private Object tvlRatio;
        @JsonProperty("last_updated")
        private String lastUpdated;
        @JsonProperty("quote")
        private Quote quote;
    }

    @Data
    public static class Platform {
        @JsonProperty("id")
        private int id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("symbol")
        private String symbol;
        @JsonProperty("slug")
        private String slug;
        @JsonProperty("token_address")
        private String tokenAddress;
    }

    @Data
    public static class Quote {
        @JsonProperty("USD")
        private Usd usd;
    }

    @Data
    public static class Usd {
        @JsonProperty("price")
        private double price;
        @JsonProperty("volume_24h")
        private double volume24h;
        @JsonProperty("volume_change_24h")
        private double volumeChange24h;
        @JsonProperty("percent_change_1h")
        private double percentChange1h;
        @JsonProperty("percent_change_24h")
        private double percentChange24h;
        @JsonProperty("percent_change_7d")
        private double percentChange7d;
        @JsonProperty("percent_change_30d")
        private double percentChange30d;
        @JsonProperty("percent_change_60d")
        private double percentChange60d;
        @JsonProperty("percent_change_90d")
        private double percentChange90d;
        @JsonProperty("market_cap")
        private double marketCap;
        @JsonProperty("market_cap_dominance")
        private double marketCapDominance;
        @JsonProperty("fully_diluted_market_cap")
        private double fullyDilutedMarketCap;
        @JsonProperty("tvl")
        private Object tvl;
        @JsonProperty("last_updated")
        private String lastUpdated;
    }
}
