package com.lastminute.flightsearch.data.access;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.lastminute.flightsearch.data.entity.Flight;

public class FlightSearcherImpl implements FlightSearcher {
    final String COMMA_DELIMITER = ",";
    final String DATA_FILE = "flights.csv";

    private static List<Flight> flights;

    public FlightSearcherImpl() {
        flights = fillFlights();
    }

    private List<Flight> fillFlights() {
        List<Flight> flights = new ArrayList<>();
        String flightFilePath = getClass().getClassLoader()
                .getResource(DATA_FILE).getFile();

        try (Scanner scanner = new Scanner(new File(flightFilePath))) {
            while (scanner.hasNextLine()) {
                Flight flight = parseFlight(scanner.nextLine());
                if (flight != null) {
                    flights.add(flight);
                }
            }
        } catch (FileNotFoundException exception) {
        }

        return flights;
    }

    private Flight parseFlight(String line) {
        List<String> values = new ArrayList<>();

        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        
        if (values.size() != 4) {
            return null;
        }
        return new Flight(values.get(2), values.get(0), values.get(1),
                new BigDecimal(values.get(3)));
    }

    @Override
	public List<Flight> search(String origin, String destination) {
        return flights
            .stream()
            .filter(flight -> flight.getOrigin().equals(origin)
                    && flight.getDestination().equals(destination))
            .collect(Collectors.toList()); 
	}
}

    