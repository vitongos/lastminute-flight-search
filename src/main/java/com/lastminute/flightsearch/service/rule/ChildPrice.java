package com.lastminute.flightsearch.service.rule;

import java.math.BigDecimal;

public class ChildPrice extends AbstractPeople implements Price {
    public ChildPrice(int peopleCount) {
        super(peopleCount);
    }

    @Override
    public BigDecimal apply(BigDecimal basePrice) {
        if (peopleCount == 0) {
            return BigDecimal.ZERO;
        }
        return basePrice.multiply(new BigDecimal(peopleCount))
                .multiply(new BigDecimal("0.67"));
    }
}