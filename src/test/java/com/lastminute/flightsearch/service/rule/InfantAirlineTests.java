package com.lastminute.flightsearch.service.rule;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

public class InfantAirlineTests {
    private static InfantAirline infantAirlineRule;

    @BeforeClass
    public static void initInfantAirline() {
        infantAirlineRule = new InfantAirline(0);
    }
    
    @Test
    public void someAdultsSuccess() {
        infantAirlineRule.setPeopleCount(2);
        BigDecimal price = infantAirlineRule.apply("IB");
        assertEquals("20", price.toString());
    }
    
    @Test
    public void zeroAdultsSuccess() {
        infantAirlineRule.setPeopleCount(0);
        BigDecimal price = infantAirlineRule.apply("IB");
        assertEquals(BigDecimal.ZERO, price);
    }

    @Test
    public void nonPositiveAdultsSuccess() {
        infantAirlineRule.setPeopleCount(-10);
        BigDecimal price = infantAirlineRule.apply("IB");
        assertEquals(BigDecimal.ZERO, price);
    }
}
