package com.lastminute.flightsearch.service.rule;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChildPriceTests {
    private static ChildPrice childPriceRule;
 
    @BeforeClass
    public static void initChildPrice() {
        childPriceRule = new ChildPrice(0);
    }
	
    @Test
    public void someChildren1Success() {
        childPriceRule.setPeopleCount(2);
        BigDecimal price = childPriceRule.apply(new BigDecimal("100"));
        assertEquals("134.00", price.toString());
    }
    
    @Test
    public void someChildren2Success() {
        childPriceRule.setPeopleCount(3);
        BigDecimal price = childPriceRule.apply(new BigDecimal("150"));
        assertEquals("301.50", price.toString());
    }
    
    @Test
    public void zeroChildrenSuccess() {
        childPriceRule.setPeopleCount(0);
        BigDecimal price = childPriceRule.apply(new BigDecimal("100"));
        assertEquals(BigDecimal.ZERO, price);
    }

    @Test
    public void nonPositiveChildrenSuccess() {
        childPriceRule.setPeopleCount(-10);
        BigDecimal price = childPriceRule.apply(new BigDecimal("100"));
        assertEquals(BigDecimal.ZERO, price);
    }
}
