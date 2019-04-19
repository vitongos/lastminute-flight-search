package com.lastminute.flightsearch.service.rule;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

public class DatePriceTests {
    private static DatePrice datePriceRule;
 
    @BeforeClass
    public static void initDatePrice() {
        datePriceRule = new DatePrice(LocalDate.now());
    }
    
    @Test
    public void date80Success() {
        datePriceRule.setDate(LocalDate.now().plusDays(100));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("80.0", price.toString());
    }
    
    @Test
    public void date80LimitSuccess() {
        datePriceRule.setDate(LocalDate.now().plusDays(31));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("80.0", price.toString());
    }
    
    @Test
    public void date100Success() {
        datePriceRule.setDate(LocalDate.now().plusDays(30));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("100", price.toString());
    }
    
    @Test
    public void date100LimitSuccess() {
        datePriceRule.setDate(LocalDate.now().plusDays(16));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("100", price.toString());
    }
    
    @Test
    public void date120Success() {
        datePriceRule.setDate(LocalDate.now().plusDays(15));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("120.0", price.toString());
    }
    
    @Test
    public void date120LimitSuccess() {
        datePriceRule.setDate(LocalDate.now().plusDays(3));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("120.0", price.toString());
    }
    
    @Test
    public void date150Success() {
        datePriceRule.setDate(LocalDate.now().plusDays(2));
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("150.0", price.toString());
    }
    
    @Test
    public void date150LimitSuccess() {
        datePriceRule.setDate(LocalDate.now());
        BigDecimal price = datePriceRule.apply(new BigDecimal("100"));
        assertEquals("150.0", price.toString());
    }
}
