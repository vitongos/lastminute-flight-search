package com.lastminute.flightsearch.service.rule;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

public class AdultPriceTests {
    private static AdultPrice adultPriceRule;
 
    @BeforeClass
    public static void initAdultPrice() {
        adultPriceRule = new AdultPrice(0);
    }
	
    @Test
    public void someAdultsSuccess() {
        adultPriceRule.setPeopleCount(2);
        BigDecimal price = adultPriceRule.apply(new BigDecimal("100"));
        assertEquals("200", price.toString());
    }
    
    @Test
    public void zeroAdultsSuccess() {
        adultPriceRule.setPeopleCount(0);
        BigDecimal price = adultPriceRule.apply(new BigDecimal("100"));
        assertEquals(BigDecimal.ZERO, price);
    }

    @Test
    public void nonPositiveAdultsSuccess() {
        adultPriceRule.setPeopleCount(-10);
        BigDecimal price = adultPriceRule.apply(new BigDecimal("100"));
        assertEquals(BigDecimal.ZERO, price);
    }
}
