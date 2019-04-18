package com.lastminute.flightsearch.data.entity;

import java.math.BigDecimal;

public class Flight {
    private String code;
    private String origin;
    private String destination;
    private BigDecimal basePrice;

    public Flight(String code, String origin, String destination,
            BigDecimal basePrice) {
        this.code = code;
        this.origin = origin;
        this.destination = destination;
        this.basePrice = basePrice;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the basePrice
     */
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public String getAirline() {
        return code.substring(0, 2);
    }
}