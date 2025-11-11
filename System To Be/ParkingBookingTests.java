import SystemToBe.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ParkingBookingTests {

    @Test
    public void testParkingBookingDetails() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Client student = ClientFactory.createClient("visitor", "john@example.com", "Password@123");
        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
        assertEquals(true, Client.isEmailValid(student.getEmail()));
        assertEquals(true, Client.isPasswordValid(student.getPassword()));
        assertEquals(true, 15 == student.getParkingRate());

        ParkingSpaceEnable enable = new ParkingSpaceEnable(space1.getLocation(), true);
        assertEquals(true, enable.isEnabled());

        ParkingSpaceDisable disable = new ParkingSpaceDisable(space1.getLocation(), false);
        assertEquals(false, disable.isEnabled());

        ParkingLotEnable enableLot = new ParkingLotEnable(lot1.getName());
        assertEquals(false, enableLot.isEnable());
        enableLot.setEnable(true);
        assertEquals(true, enableLot.isEnable());

        ParkingLotDisable disableLot = new ParkingLotDisable(lot1.getName());
        assertEquals(false, disableLot.isEnable());

    }

    @Test
    public void testParkingBookingRate() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Client student = ClientFactory.createClient("student", "john@example.com", "Password@123");
        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
        assertEquals("ABC123", booking.getLicensePlace());
        assertEquals(true, student.getParkingRate()*1 == booking.getAmount(booking));

        Payment payment = new Payment();
        assertEquals(true, 15.0 == payment.getAmount(3, student));
    }

    @Test
    public void testParkingBookingTime() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Client student = ClientFactory.createClient("faculty", "john@example.com", "Password@123");
        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
        assertEquals(true, booking.getStartTime().getTime() < booking.getEndTime().getTime());
    }

    @Test
    public void testParkingBookingEdit() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Client student = ClientFactory.createClient("non-faculty", "john@example.com", "Password@123");
        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
        long before = booking.getStartTime().getTime();
        Date newStartTime = new Date(startTime.getTime() + 60 * 60 * 1000); // Add 1 hour
        Booking.editBooking(newStartTime, booking);
        long after = booking.getStartTime().getTime();
        assertEquals(60 * 60 * 1000, after-before);
    }

    @Test
    public void testParkingBookingCancel() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Client student = ClientFactory.createClient("student", "john@example.com", "Password@123");
        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = student.doBooking("ABC123", space1, startTime, student.getParkingRate());
        assertNotNull(booking.getLicensePlace());
        assertNotNull(booking.getSpace());
        assertNotNull(booking.getStartTime());
        assertEquals(true, booking.getHour() > 0);
        assertEquals(true, booking.getAmount(booking) > 0);
        Booking.cancelBooking(booking);
        assertNull(booking.getLicensePlace());
        assertNull(booking.getStartTime());
        assertEquals(false, booking.getHour() > 0);
        assertEquals(false, booking.getAmount(booking) > 0);
    }
}
