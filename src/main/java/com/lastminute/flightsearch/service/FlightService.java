package com.lastminute.flightsearch.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lastminute.flightsearch.data.access.FlightSearcher;
import com.lastminute.flightsearch.data.entity.Flight;
import com.lastminute.flightsearch.model.FlightResult;
import com.lastminute.flightsearch.service.rule.Airline;
import com.lastminute.flightsearch.service.rule.Price;

public class FlightService {
    private FlightSearcher flightSearcher;
    private Price adultPriceRule;
    private Price childPriceRule;
    private Price datePriceRule;
    private Airline infantAirlineRule;

    public FlightService(FlightSearcher flightSearcher, Price adultPriceRule,
            Price childPriceRule, Price datePriceRule,
            Airline infantAirlineRule) {
        this.flightSearcher = flightSearcher;
        this.adultPriceRule = adultPriceRule;
        this.childPriceRule = childPriceRule;
        this.datePriceRule = datePriceRule;
        this.infantAirlineRule = infantAirlineRule;
    }

    private FlightResult getResult(Flight flight) {
        BigDecimal finalPrice = BigDecimal.ZERO
                .add(applyAdultRule(flight.getBasePrice()))
                .add(applyChildRule(flight.getBasePrice()))
                .add(applyInfantRule(flight.getAirline()));

        return new FlightResult(flight.getCode(), finalPrice);
    }

    private BigDecimal applyAdultRule(BigDecimal basePrice) {
        return adultPriceRule.apply(datePriceRule.apply(basePrice));
    }

    private BigDecimal applyChildRule(BigDecimal basePrice) {
        return childPriceRule.apply(datePriceRule.apply(basePrice));
    }

    private BigDecimal applyInfantRule(String airline) {
        return infantAirlineRule.apply(airline);
    }

    public List<FlightResult> search(String origin, String destination) {
        List<FlightResult> flightResults = new ArrayList<>();
        List<Flight> flights = flightSearcher.search(origin, destination);

        for (Flight flight: flights) {
            FlightResult flightResult = getResult(flight);
            flightResults.add(flightResult);
        }
        
        return flightResults;
    }
}