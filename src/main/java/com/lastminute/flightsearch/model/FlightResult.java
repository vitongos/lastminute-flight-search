package com.lastminute.flightsearch.model;

import java.math.BigDecimal;

public class FlightResult {
    private String code;
    private BigDecimal totalPrice;

    public FlightResult(String code, BigDecimal totalPrice) {
        this.code = code;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return code + ", " 
                + totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP) + " €";
    }
}