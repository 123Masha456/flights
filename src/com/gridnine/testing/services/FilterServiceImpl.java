package com.gridnine.testing.services;

import com.gridnine.testing.dto.Flight;
import com.gridnine.testing.dto.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterServiceImpl implements FilterService {
    @Override
    public List<Flight> departureBeforeNow(List<Flight> flights) {


        List<Segment> newSegments = new ArrayList<>();

        List<Flight> filteredFlights = new ArrayList<>();


        for (var i = 0; i < flights.size(); i = i + 1) {
            var result = flights.get(i);
            var eachSegment = result.getSegments();


            for (Segment segment : eachSegment) {
                var dep = segment.getDepartureDate();

                if (LocalDateTime.now().getDayOfMonth() > dep.getDayOfMonth()
                        && LocalDateTime.now().getHour() > dep.getHour()
                        && LocalDateTime.now().getMinute() > dep.getMinute()) {

                    newSegments.add(segment);

                    Flight newFlight = new Flight(newSegments);

                    filteredFlights.add(newFlight);
                }
            }
        }
        return filteredFlights;
    }

    @Override
    public List<Flight> arriveBeforeDeparture(List<Flight> flights) {

        List<Segment> newSegments = new ArrayList<>();

        List<Flight> filteredFlights = new ArrayList<>();

        for (var i = 0; i < flights.size(); i = i + 1) {
            var result = flights.get(i);
            var eachSegment = result.getSegments();

            for (Segment segment : eachSegment) {
                var dep = segment.getDepartureDate();
                var arr = segment.getArrivalDate();

                if (arr.getYear() < dep.getYear()
                        && arr.getMonth().equals(dep.getMonth())
                        && arr.getDayOfMonth() < dep.getDayOfMonth()) {

                    newSegments.add(segment);

                    Flight newFlight = new Flight(newSegments);

                    filteredFlights.add(newFlight);
                }
            }
        }
        return filteredFlights;
    }

    @Override
    public List<Flight> breakMoreThanTwoHours(List<Flight> flights) {

        List<Segment> newSegments = new ArrayList<>();

        List<Flight> filteredFlights = new ArrayList<>();

        var i = 0;
        for (; i < flights.size(); i = i + 1) {
            var result = flights.get(i);
            var eachSegment = result.getSegments();
            var count = eachSegment.size();


            for (var j = 0; j < count - 1; j = j + 1) {
                var between = eachSegment.get(j).getArrivalDate().getHour()
                        - eachSegment.get(j + 1).getDepartureDate().getHour();
                if (between >= 2) {
                    for (Segment segment : eachSegment) {

                        newSegments.add(segment);

                        Flight newFlight = new Flight(newSegments);

                        filteredFlights.add(newFlight);
                    }
                }
            }
        }
        return filteredFlights;
    }
}

