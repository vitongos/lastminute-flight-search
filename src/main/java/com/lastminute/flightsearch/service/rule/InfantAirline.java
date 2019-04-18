package com.lastminute.flightsearch.service.rule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InfantAirline extends AbstractPeople implements Airline {
    public InfantAirline(int peopleCount) {
        super(peopleCount);
    }

    private Map<String, BigDecimal> getFixedPrices() {
        Map<String, BigDecimal> fixedPrices = new HashMap<>();

        fixedPrices.put("IB", new BigDecimal("10"));
        fixedPrices.put("BA", new BigDecimal("15"));
        fixedPrices.put("LH", new BigDecimal("7"));
        fixedPrices.put("FR", new BigDecimal("20"));
        fixedPrices.put("VY", new BigDecimal("10"));
        fixedPrices.put("TK", new BigDecimal("5"));
        fixedPrices.put("U2", new BigDecimal("19.90"));
        
        return fixedPrices;
    }

    @Override
    public BigDecimal apply(String airline) {
        if (peopleCount == 0) {
            return BigDecimal.ZERO;
        }
        return getFixedPrices().get(airline)
                .multiply(new BigDecimal(peopleCount));
    }
}