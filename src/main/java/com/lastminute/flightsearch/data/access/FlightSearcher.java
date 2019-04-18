package com.lastminute.flightsearch.data.access;

import java.util.List;

import com.lastminute.flightsearch.data.entity.Flight;

public interface FlightSearcher {
    public List<Flight> search(String origin, String destination);
}