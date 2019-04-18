package com.lastminute.flightsearch.service.rule;

import java.math.BigDecimal;

public interface Airline {
    public BigDecimal apply(String airline);
}