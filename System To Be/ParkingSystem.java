package SystemToBe;

//Importing the required classes from the Java utility library
import java.util.ArrayList;
import java.util.List;

public class ParkingSystem{
	private static ParkingSystem instance = null;
	private List<ManagementAccounts> managers = new ArrayList<>();
	private List<Parkinglot> parkingLots = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();

	ParkingSystem() {
	}
	
	public static ParkingSystem getInstance() {
		if (instance == null) {
			instance = new ParkingSystem();
		}
		return instance;
	}
	
	public void addManager(ManagementAccounts manager) {
        managers.add(manager);
    }
	
	public void addParkingLot(Parkinglot parkingLot) {
        parkingLots.add(parkingLot);
        System.out.println("Parking lot added: " + parkingLot.getName());
    }
	
	public List<Parkinglot> getParkingLots() {
		return parkingLots;
	}
}
