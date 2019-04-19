package com.lastminute.flightsearch.data.access;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.lastminute.flightsearch.data.entity.Flight;

import org.junit.BeforeClass;
import org.junit.Test;

public class FlightSearcherImplTests {
    private static FlightSearcherImpl flightSearcher;
 
    @BeforeClass
    public static void initSearcher() {
        flightSearcher = new FlightSearcherImpl();
    }
    
    @Test
    public void findFlightSuccess() {
        List<Flight> flights = flightSearcher.search("IST", "LHR");
        assertEquals(3, flights.size());
    }

    @Test
    public void findFlightNoMatches() {
        List<Flight> flights = flightSearcher.search("BCN", "CDG");
        assertEquals(0, flights.size());
    }
}
