package com.gridnine.testing;

import java.util.List;

public class Main {
    private static Filter filter = new Filter();

    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> flightListTwo = Filter.useFilterTimeBeforeDeparture(flightList);
        List<Flight> flightListThree = Filter.useFilterTimeDepartureArrival(flightListTwo);
        List<Flight> flightLisFour = Filter.useFilterAfterTwoHours(flightListThree);
        System.out.println("Изначальный список:\n" + flightList);
        System.out.println("Отредактированный список по времени вылета до нынешнего времени\n" + flightListTwo);
        System.out.println("Отредактированный список по времени вылета и времени прилёта\n" + flightListThree);
        System.out.println("Отредактированный список по времени полета\n" + flightLisFour);
    }
}