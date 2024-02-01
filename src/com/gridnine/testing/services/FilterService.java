package com.gridnine.testing.services;

import com.gridnine.testing.dto.Flight;
import com.gridnine.testing.dto.Segment;

import java.util.List;

public interface FilterService {
    List<Flight> departureBeforeNow(List<Flight> flights);
    List<Flight> arriveBeforeDeparture(List<Flight> flights);
    List<Flight> breakMoreThanTwoHours(List<Flight> flights);
}
