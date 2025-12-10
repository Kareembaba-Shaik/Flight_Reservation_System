## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure
flight-reservation-system-java/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── flights/
│   │                   ├── Flight.java
│   │                   ├── Reservation.java
│   │                   ├── FlightService.java
│   │                   └── Main.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── flights/
│                       └── FlightServiceTest.java
│
├── README.md
└── .gitignore

#  Flight Reservation System – Java

A console-based Java application demonstrating core OOP principles, collections, service design, and unit testing.

## Features
- Search flights by **destination** and **date**
- Book flights with **seat availability checks**
- View customer reservations
- In-memory data storage (no DB needed)
- Clean, modular OOP design
- JUnit test coverage for service layer

---

# Flight Reservation System

This project implements a simple console-based Flight Reservation System in Java.

## Features
✔ Search flights by destination and date  
✔ Book flights with seat validation  
✔ View reservations for a customer  
✔ In-memory data storage (no database needed)  
✔ Fully object-oriented design  
✔ Unit tests using JUnit  

## Classes
- Flight — represents a flight
- Reservation — represents a booking
- FlightService — handles search, booking, and reservation storage
- Main — console UI to interact with the system

## How to Run
1. Compile all `.java` files
2. Run the `Main` class
3. Follow the console menu

## How to Test
Run `FlightServiceTest` using JUnit 5.

## Design Decisions
- Used ArrayList for in-memory storage due to simplicity.
- Prevented overbooking by validating seat count.
- Streams API used for clean filtering logic.


## Tech Stack
- **Java 8+**
- **JUnit 5**
- **Stream API**
- **OOP principles**
- **Console interaction**

---
# Java
*.class
*.jar
*.war

# Maven
target/

# IntelliJ
.idea/
*.iml
out/

# Eclipse
.project
.classpath
.settings/

