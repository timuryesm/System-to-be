package SystemToBe;

import java.util.Date;


public class Main {

    public static void main(String[] args) {
        // Create a new Client
    	ParkingSystem sys = ParkingSystem.getInstance();
    	SuperManager su = new SuperManager("su@example.com", "Psc-SCs-213vD");
    	
    	ManagementAccounts manager1 = su.generateAccount("johndoe123@gmail.com", "Password@123");
    	ManagementAccounts manager2 = su.generateAccount("sarahsmith456@yahoo.com", "Password@123");
    	
    	Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
    	Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");
    	
        Client student = ClientFactory.createClient("student", "john@example.com", "Password@123");
        Client faculty = ClientFactory.createClient("faculty", "jane@example.com", "Password@123");
        Client nonFaculty = ClientFactory.createClient("non-faculty", "bob@example.com", "Password@123");
        Client visitor = ClientFactory.createClient("visitor", "susan@example.com", "Password@123");

        // Check if the email and password are valid
        System.out.println("Is email valid: " + Client.isEmailValid(student.getEmail()));
        System.out.println("Is password valid: " + Client.isPasswordValid(student.getPassword()));

        // Book a parking space for the client
        ParkingSpace space1 = lot1.getParkingSpace(1);
        ParkingSpace space2 = lot1.getParkingSpace(10);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
//        space1.occupy();
        Booking booking2 = visitor.doBooking("ABC124", space2, startTime, visitor.getParkingRate());
//        space1.getLocation()
//        space1
        // Get the start and end times of the booking
        System.out.println("Start time: " + booking.getStartTime());
        System.out.println("End time: " + booking.getEndTime());

        // Edit the booking start time
        Date newStartTime = new Date(startTime.getTime() + 60 * 60 * 1000); // Add 1 hour
        Booking.editBooking(newStartTime, booking);
        System.out.println("New start time: " + booking.getStartTime());

        // Extend the booking
        Booking.extendBooking(3, booking); // Add 1 hour
        System.out.println("New end time: " + booking.getEndTime());

        // Cancel the booking
        System.out.println("License plate: " + booking.getLicensePlace());
        System.out.println("Space: " + booking.getSpace());
        System.out.println("Start time: " + booking.getStartTime());
        System.out.println("Start time: " + booking.getEndTime());
        System.out.println("Total hours: " + booking.getHour());
        System.out.println("Amount for " + booking.getHour() + " hours : " + booking.getAmount(booking));
        

        Booking.cancelBooking(booking);
    }
}