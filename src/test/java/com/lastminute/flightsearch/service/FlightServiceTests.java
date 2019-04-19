package com.lastminute.flightsearch.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import com.lastminute.flightsearch.data.access.FlightSearcherImpl;
import com.lastminute.flightsearch.model.FlightResult;
import com.lastminute.flightsearch.service.rule.AdultPrice;
import com.lastminute.flightsearch.service.rule.ChildPrice;
import com.lastminute.flightsearch.service.rule.DatePrice;
import com.lastminute.flightsearch.service.rule.InfantAirline;

import org.junit.Test;

public class FlightServiceTests {
    @Test
    public void case1Success() {
        FlightService flightService = new FlightService(
            new FlightSearcherImpl(),
            new AdultPrice(1),
            new ChildPrice(0),
            new DatePrice(LocalDate.now().plusDays(31)),
            new InfantAirline(0)
        );
        List<FlightResult> results = flightService.search("AMS", "FRA");
        assertEquals("TK2372, 157.60 €", results.get(0).toString());
        assertEquals("TK2659, 198.40 €", results.get(1).toString());
        assertEquals("LH5909, 90.40 €", results.get(2).toString());
    }
    
    @Test
    public void case2Success() {
        FlightService flightService = new FlightService(
            new FlightSearcherImpl(),
            new AdultPrice(2),
            new ChildPrice(1),
            new DatePrice(LocalDate.now().plusDays(15)),
            new InfantAirline(1)
        );
        List<FlightResult> results = flightService.search("LHR", "IST");
        assertEquals("TK8891, 806.00 €", results.get(0).toString());
        assertEquals("LH1085, 481.19 €", results.get(1).toString());
    }
    
    @Test
    public void case3Success() {
        FlightService flightService = new FlightService(
            new FlightSearcherImpl(),
            new AdultPrice(1),
            new ChildPrice(2),
            new DatePrice(LocalDate.now().plusDays(2)),
            new InfantAirline(0)
        );
        List<FlightResult> results = flightService.search("BCN", "MAD");
        assertEquals("IB2171, 909.09 €", results.get(0).toString());
        assertEquals("LH5496, 1028.43 €", results.get(1).toString());
    }
    
    @Test
    public void caseNotFound() {
        FlightService flightService = new FlightService(
            new FlightSearcherImpl(),
            new AdultPrice(1),
            new ChildPrice(2),
            new DatePrice(LocalDate.now().plusDays(2)),
            new InfantAirline(0)
        );
        List<FlightResult> results = flightService.search("CDG", "FRA");
        assertEquals(0, results.size());
    }
}
