package main.java.com.example.flights;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        Scanner scanner = new Scanner(System.in);

        // Pre-loaded flights
        flightService.addFlight(new Flight("AI101", "New York",
                LocalDateTime.of(2025, 1, 12, 10, 30), 50));
        flightService.addFlight(new Flight("AI202", "Dallas",
                LocalDateTime.of(2025, 1, 12, 14, 15), 30));
        flightService.addFlight(new Flight("AI303", "New York",
                LocalDateTime.of(2025, 1, 12, 18, 00), 10));

        System.out.println("Welcome to the Flight Reservation System!");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();

                    System.out.print("Enter date (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    
                    try {
                        // Append time to convert LocalDate string to LocalDateTime for parsing
                        LocalDateTime date = LocalDateTime.parse(dateStr + "T00:00:00");
                        List<Flight> flights = flightService.searchFlights(destination, date);
                        
                        if (flights.isEmpty()) {
                            System.out.println("No flights found for that destination/date.");
                        } else {
                            System.out.println("\nAvailable Flights:");
                            flights.forEach(System.out::println);
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter flight number (e.g., AI101): ");
                    String flightNo = scanner.nextLine();

                    int seats;
                    try {
                        System.out.print("Enter seats: ");
                        seats = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number of seats.");
                        break;
                    }

                    // FIXED: Look up the flight directly by ID
                    Flight selectedFlight = flightService.findFlightByNumber(flightNo);

                    if (selectedFlight == null) {
                        System.out.println("Flight not found with number: " + flightNo);
                        break;
                    }

                    Reservation res = flightService.bookFlight(name, selectedFlight, seats);
                    if (res != null) {
                        System.out.println("Booking successful! " + res);
                    }
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String customer = scanner.nextLine();

                    List<Reservation> reservations = flightService.getReservationsForCustomer(customer);

                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found for " + customer);
                    } else {
                        System.out.println("\nYour Reservations:");
                        reservations.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }
}