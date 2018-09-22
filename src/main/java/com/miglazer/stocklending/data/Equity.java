package com.miglazer.stocklending.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Data
public class Equity {

    private String symbol;
    private BigDecimal price;

    public Equity(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    public List<Equity> goodEquities() {
        return Arrays.asList(
                new Equity("IBM", new BigDecimal("100.45")),
                new Equity("MSFT", new BigDecimal("39.43")));

    }

    @Override
    public String toString() {
        return "Equity{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
