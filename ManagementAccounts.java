package SystemToBe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class ManagementAccounts extends SuperManager {
    
    private String lotName;
    private Parkinglot parkinglot;
    private ParkingSpace parkingSpace;
    private Client client;
    private boolean enabled;
    
    public ManagementAccounts(String username, String password) {
        super(username, password);
    }
    
    public Parkinglot addParkingLotToSystem(String name) {
        ParkingSystem parkingSystem = ParkingSystem.getInstance();
        Parkinglot parkingLot = new Parkinglot(name);
        parkingSystem.addParkingLot(parkingLot);
        return parkingLot;
    }

	public void enableLot() {
        if (parkinglot != null) {
            parkinglot.setEnable(true);
            System.out.println("This space is already occupied.");
        }
    }
    
    public void disableLot(){
        if (parkinglot != null) {
            parkinglot.setEnable(false);
        }
    }
    
    public void enableSpace(ParkingSpace space, Parkinglot lot) {
        if (lot.getParkingSpace(space.getUIN()) != null) {
            space.setEnabled(true);
        }
    }
    
    public void disableSpace(ParkingSpace space, Parkinglot lot) {
        if (lot.getParkingSpace(space.getUIN()) != null) {
            space.setEnabled(false);
        }
    }
    
//    public void add() {
//    	parkinglot.
//    }
    
    public boolean enable() {
        return enabled;
    }
    
    public boolean disable(){
        return !enabled;
    }
}
