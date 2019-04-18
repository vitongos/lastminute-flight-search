package com.lastminute.flightsearch.service.rule;

import java.math.BigDecimal;

public interface Price {
    public BigDecimal apply(BigDecimal basePrice);
}