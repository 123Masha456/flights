import com.gridnine.testing.dto.Flight;
import com.gridnine.testing.services.FlightBuilder;

import com.gridnine.testing.services.FilterServiceImpl;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        FilterServiceImpl filterService = new FilterServiceImpl();

        List<Flight> filteredFlights1 = filterService.departureBeforeNow(flights);
        System.out.println(filteredFlights1);

        List<Flight> filteredFlights2 = filterService.arriveBeforeDeparture(flights);
        System.out.println(filteredFlights2);

        List<Flight> filteredFlights3 = filterService.breakMoreThanTwoHours(flights);
        System.out.println(filteredFlights3);


    }
    private static void eachFlight(List<Flight> flights){
        for(Flight flight : flights){
            System.out.println(flight);
        }

    }
}