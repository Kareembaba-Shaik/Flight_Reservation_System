import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FlightServiceTest {

    private FlightService flightService;

    @BeforeEach
    void setup() {
        flightService = new FlightService();
        flightService.addFlight(new Flight("F001", "New York",
                LocalDateTime.of(2025, 1, 12, 10, 30), 20));
    }

    @Test
    void testSearchFlights() {
        List<Flight> flights = flightService.searchFlights(
                "New York",
                LocalDateTime.of(2025, 1, 12, 0, 0));

        Assertions.assertEquals(1, flights.size());
    }

    @Test
    void testBookFlightSuccess() {
        Flight flight = flightService.searchFlights(
                "New York",
                LocalDateTime.of(2025, 1, 12, 0, 0)).get(0);

        Reservation res = flightService.bookFlight("John", flight, 2);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(18, flight.getAvailableSeats());
    }

    @Test
    void testBookFlightFailNotEnoughSeats() {
        Flight flight = flightService.searchFlights(
                "New York",
                LocalDateTime.of(2025, 1, 12, 0, 0)).get(0);

        Reservation res = flightService.bookFlight("John", flight, 100);
        Assertions.assertNull(res);
    }
}
