package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    private static List<Flight> flightTimeOne = new ArrayList<>(List.of());
    private static List<Flight> flightTimeTwo = new ArrayList<>(List.of());
    private static List<Flight> flightTimeThree = new ArrayList<>(List.of());
    private static Segment segment;
    private static Segment segmentArrival;

    public static List<Flight> useFilterTimeBeforeDeparture(List<Flight> list) {
        for (int i = 0; i < list.size(); i++) {
            Flight flight = list.get(i);
            segment = flight.getSegments().getFirst();
            if (segment.getDepartureDate().isAfter(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))) {
                flightTimeOne.add(flight);
            }
        }
        return flightTimeOne;
    }

    public static List<Flight> useFilterTimeDepartureArrival(List<Flight> list) {
        for (int i = 0; i < list.size(); i++) {
            Flight flight = list.get(i);
            segment = flight.getSegments().getFirst();
            segmentArrival = flight.getSegments().getFirst();
            if (segment.getDepartureDate().isBefore(segmentArrival.getArrivalDate())) {
                flightTimeTwo.add(flight);
            }
        }
        return flightTimeTwo;
    }

    public static List<Flight> useFilterAfterTwoHours(List<Flight> list) {
        for (int i = 0; i < list.size(); i++) {
            Flight flight = list.get(i);
            segment = flight.getSegments().getFirst();
            segmentArrival = flight.getSegments().getLast();
            float hourDeparture = segment.getDepartureDate().getHour();
            float hourArrival = segmentArrival.getArrivalDate().getHour();
            float result = hourArrival - hourDeparture;
            if (result <= 2) {
                flightTimeThree.add(flight);
            }
        }
        return flightTimeThree;
    }
}