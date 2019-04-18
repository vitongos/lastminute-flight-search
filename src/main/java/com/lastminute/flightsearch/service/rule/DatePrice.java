package com.lastminute.flightsearch.service.rule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DatePrice implements Price {
    private LocalDate date;

    public DatePrice(LocalDate date) {
        this.date = date;
    }

    @Override
    public BigDecimal apply(BigDecimal basePrice) {
        BigDecimal price = basePrice;
        LocalDate today = LocalDate.now();
        long diff = ChronoUnit.DAYS.between(today, date);

        if (diff >= 31) {
            price = basePrice.multiply(new BigDecimal("0.8"));
        } else if ((diff <= 15) && (diff >=3)) {
            price = basePrice.multiply(new BigDecimal("1.2"));
        } else if (diff <= 2) {
            price = basePrice.multiply(new BigDecimal("1.5"));
        }
        
        return price;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
}