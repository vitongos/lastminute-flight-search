package com.lastminute.flightsearch.model;

import java.time.LocalDate;

public class SearchCriteria {
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private int adults;
    private int children;
    private int infants;

    public SearchCriteria(String origin, String destination,
            LocalDate departureDate, int adults, int children,
            int infants) {
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setDepartureDate(departureDate);
        this.setAdults(adults);
        this.setChildren(children);
        this.setInfants(infants);
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
     * @return the departureDate
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the adults
     */
    public int getAdults() {
        return adults;
    }

    /**
     * @param adults the adults to set
     */
    public void setAdults(int adults) {
        this.adults = adults;
    }

    /**
     * @return the children
     */
    public int getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(int children) {
        this.children = children;
    }

    /**
     * @return the infants
     */
    public int getInfants() {
        return infants;
    }

    /**
     * @param infants the infants to set
     */
    public void setInfants(int infants) {
        this.infants = infants;
    }
}