package com.example.demo.converter;

import java.util.Map;

public class ExchangeRateResponse {
    
    private String base;
    private long timestamp;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "base='" + base + '\'' +
                ", timestamp=" + timestamp +
                ", rates=" + rates +
                '}';
    }
}
