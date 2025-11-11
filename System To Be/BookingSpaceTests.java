import SystemToBe.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BookingSpaceTests {

    @Test
    public void testParkingLotSpaceValid() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        ManagementAccounts manager2 = new ManagementAccounts("sarahsmith456@yahoo.com", "Password@123");

        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");

        assertEquals(100, lot1.getParkingSpaces().size());
        assertEquals(100, lot2.getParkingSpaces().size());

        ParkingSpace space1 = lot1.getParkingSpace(1);
        assertNotNull(space1);
    }

    @Test
    public void testParkingLotSpaceInvalid() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        ManagementAccounts manager2 = new ManagementAccounts("sarahsmith456@yahoo.com", "Password@123");
        Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");
        ParkingSpace space2 = lot2.getParkingSpace(110);
        assertNull(space2);
    }

    @Test
    public void testParkingLotSpaceManager() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        ManagementAccounts manager2 = new ManagementAccounts("sarahsmith456@yahoo.com", "Password@123");
        sys.addManager(manager1);
        sys.addManager(manager2);
        assertEquals(0, sys.getParkingLots().size());
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");
        assertEquals(2, sys.getParkingLots().size());
    }

    @Test
    public void testParkingLotSpaceFaculty() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        ManagementAccounts manager2 = new ManagementAccounts("sarahsmith456@yahoo.com", "Password@123");
        sys.addManager(manager1);
        sys.addManager(manager2);
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");
        Client faculty = ClientFactory.createClient("faculty",
                "bob@example.com", "Password@123");

        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = faculty.doBooking("ABC123", space1, startTime, faculty.getParkingRate());
        assertEquals(true,faculty.getParkingRate() == booking.getAmount(booking));

        assertEquals(false, ((Faculty)faculty).isValidated());
        ((Faculty)faculty).setValidation(true);
        assertEquals(true, ((Faculty)faculty).isValidated());

        assertEquals("lot1", lot1.getName());
        assertEquals("lot2", lot2.getName());

        assertEquals(true, lot1.isEnable());
        lot1.setEnable(false);
        assertEquals(false, lot1.isEnable());
    }

    @Test
    public void testParkingLotSpaceNonFaculty() {
        ParkingSystem sys = ParkingSystem.getInstance();
        ManagementAccounts manager1 = new ManagementAccounts("johndoe123@gmail.com", "Password@123");
        ManagementAccounts manager2 = new ManagementAccounts("sarahsmith456@yahoo.com", "Password@123");
        sys.addManager(manager1);
        sys.addManager(manager2);
        Parkinglot lot1 = manager1.addParkingLotToSystem("lot1");
        Parkinglot lot2 = manager2.addParkingLotToSystem("lot2");
        Client nonFaculty = ClientFactory.createClient("non-faculty",
                "bob@example.com", "Password@123");

        ParkingSpace space1 = lot1.getParkingSpace(1);
        Date startTime = new Date();
        Booking booking = nonFaculty.doBooking("ABC123", space1, startTime, nonFaculty.getParkingRate());
        assertEquals(true,nonFaculty.getParkingRate() == booking.getAmount(booking));

        assertEquals(false, ((NonFaculty)nonFaculty).isValidated());
        ((NonFaculty)nonFaculty).setValidation(true);
        assertEquals(true, ((NonFaculty)nonFaculty).isValidated());
    }
}
