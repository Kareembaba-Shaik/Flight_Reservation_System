package main.java.com.example.flights;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlights(String destination, LocalDateTime date) {
        return flights.stream()
                .filter(f -> f.getDestination().equalsIgnoreCase(destination)
                        && f.getDepartureTime().toLocalDate().equals(date.toLocalDate())
                        && f.getAvailableSeats() > 0)
                .collect(Collectors.toList());
    }

    // NEW METHOD: Find a flight directly by its ID
    public Flight findFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst()
                .orElse(null);
    }

    public Reservation bookFlight(String customerName, Flight flight, int seats) {
        if (flight.getAvailableSeats() < seats) {
            System.out.println("Booking failed: Not enough seats available.");
            return null;
        }

        flight.reduceSeats(seats);
        Reservation reservation = new Reservation(customerName, flight, seats);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservationsForCustomer(String customerName) {
        return reservations.stream()
                .filter(r -> r.getCustomerName().equalsIgnoreCase(customerName))
                .collect(Collectors.toList());
    }
}