package com.lastminute.flightsearch;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.lastminute.flightsearch.data.access.FlightSearcherImpl;
import com.lastminute.flightsearch.model.FlightResult;
import com.lastminute.flightsearch.model.SearchCriteria;
import com.lastminute.flightsearch.service.FlightService;
import com.lastminute.flightsearch.service.rule.AdultPrice;
import com.lastminute.flightsearch.service.rule.ChildPrice;
import com.lastminute.flightsearch.service.rule.DatePrice;
import com.lastminute.flightsearch.service.rule.InfantAirline;

public class FlightSearchApplication {
	public static void main(String[] args) {
		try {
			SearchCriteria criteria = parseCriteria(args);

			/* Lack of DIC, injecting services here */
			FlightService service = new FlightService(new FlightSearcherImpl(),
					new AdultPrice(criteria.getAdults()),
					new ChildPrice(criteria.getChildren()),
					new DatePrice(criteria.getDepartureDate()),
					new InfantAirline(criteria.getInfants()));

			List<FlightResult> flights = service.search(criteria.getOrigin(),
					criteria.getDestination());

			if (flights.isEmpty()) {
				System.out.println("No flights available");
			} else {
				for (FlightResult f: flights) {
					System.out.println(f);
				}
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private static SearchCriteria parseCriteria(String[] args) {
		if (args.length < 3) {
			throw new IllegalArgumentException("Not enough parameters");
		}
		LocalDate date;
		int adults = 0, children = 0, infants = 0;
		String origin = args[0];
		String destination = args[1];

		try {
			date = LocalDate.parse(args[2]);
			if (date.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException(
					"Invalid date: " + args[2] + " is in the past");
			}
		} catch (DateTimeParseException exception) {
			throw new IllegalArgumentException(
				"Invalid date or date format (valid: YYYY-MM-DD)");
		}

		if (args.length >= 4) {
			adults = Integer.parseInt(args[3]);
		}
		if (args.length >= 5) {
			children = Integer.parseInt(args[4]);
		}
		if (args.length >= 6) {
			infants = Integer.parseInt(args[5]);
		}
		
		if ((adults == 0) && (children == 0) && (infants == 0)) {
			adults = 2;
		}

		return new SearchCriteria(origin, destination, date, adults, children,
				infants);
	}
}
