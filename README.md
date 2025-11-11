# 🚗 SystemToBe — Smart Parking Booking System

**SystemToBe** is an intelligent parking management and booking system developed in Java as part of the **EECS 3311 — Software Design** course at **York University**.  
The project simulates a real-world parking environment with features such as **real-time space tracking**, **automated booking validation**, **sensor-based occupancy updates**, and **secure payment integration**.

---

## 🧩 Project Overview

The system enables users (students, faculty, visitors) to:
- Book available parking spaces for specific time intervals.  
- Pay securely for bookings using stored card information.  
- Receive automatic updates when spaces become free or occupied.  
- Manage reservations dynamically — extend, edit, or cancel bookings.  

It integrates **sensor input** and **state-based logic** to ensure real-time availability and synchronization between the booking module, parking states, and payment subsystem.

---

## 🧩 System Architecture
SystemToBe/
├── Booking.java                # Handles booking creation, editing, extension, and cancellation
├── Client.java                 # Base class representing different user types
├── ClientFactory.java          # Factory class for creating Client objects
├── Command.java                # Command interface for executing operations
├── ConcreteParkingSpace.java   # Implements Observer; handles space occupancy and notifications
├── creditCard.java             # Stores and validates user credit card details
├── Faculty.java                # User subclass representing faculty members
├── FreeState.java              # State representing a free parking space
├── Main.java                   # Main entry point for running the system
├── ManagementAccounts.java     # Handles management users and their operations
├── MySystem.java               # Utility class coordinating system operations
├── NonFaculty.java             # User subclass representing non-faculty members
├── Observer.java               # Observer interface for event updates
├── OccupiedState.java          # State representing an occupied parking space
├── Parkinglot.java             # Represents a physical parking lot with multiple spaces
├── ParkingLotDisable.java      # Command to disable a parking lot
├── ParkingLotEnable.java       # Command to enable a parking lot
├── ParkingSpace.java           # Abstract class defining parking space behavior
├── ParkingSpaceDisable.java    # Command to disable a specific parking space
├── ParkingSpaceEnable.java     # Command to enable a specific parking space
├── ParkingSpaceState.java      # Interface for parking space state transitions
├── ParkingSystem.java          # Singleton controller for managing lots and managers
├── Payment.java                # Handles payment processing and validation
├── Sensor.java                 # Interface for sensors monitoring parking spaces
├── Student.java                # User subclass representing students
├── SuperManager.java           # Special management user with elevated permissions
├── Visitor.java                # User subclass representing visitors
└── … (supporting domain classes and utility components)

---

## ⚙️ Prerequisites

- **Java 8+**  
- **IDE** — IntelliJ IDEA, Eclipse, or NetBeans  
- **JUnit 5** for testing

## 🧠 Core Features

### 1. Booking Management
- `Booking.java` manages creation, modification, extension, and cancellation of reservations.  
- Automatically validates license plate, time, and duration before confirmation.  

```java
Booking booking = new Booking("ABC-123", space, new Date(), 2, 5.0);
System.out.println("End time: " + booking.getEndTime());
```
⸻

### 2. Parking Space Monitoring
-	ConcreteParkingSpace.java implements the Observer Pattern to respond to real-time sensor updates.
-	Automatically notifies all observers when occupancy status changes.

⸻

### 3. State Management
- Uses the State Pattern (FreeState, BookedState, OccupiedState) to manage transitions of parking spaces.
- Prevents invalid actions such as booking already occupied spaces.

⸻

### 4. Sensor Integration
- Sensor.java defines an interface for integrating physical or simulated parking sensors.
- Ensures that every occupancy change updates the system automatically.

⸻

### 5. System Controller (Singleton)
- ParkingSystem.java is the single coordination point for managers, parking lots, and observers.
- Uses the Singleton Pattern to ensure one centralized instance controls the system.

⸻

### 6. Payment Processing
- Payment.java validates user transactions and links them to active bookings.
- Ensures secure, modular payment management.

⸻

📄 License

This project is distributed for educational and non-commercial use under the MIT License.

⸻

🧾 In Summary

SystemToBe is a modular, design-pattern-driven parking management system written in Java.
It combines Observer, State, and Singleton architectures to simulate a realistic, real-time parking environment — complete with bookings, payments, and automated sensor updates.

The system demonstrates best practices in object-oriented programming, modularity, and concurrency-safe design, making it a strong foundation for extending toward a real-world smart parking platform.
