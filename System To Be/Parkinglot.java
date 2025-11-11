package SystemToBe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class Parkinglot {

    private String name;
    private boolean enable;
    private List<ParkingSpace> parkingSpaces;

    public Parkinglot(String name) {
        this.name = name;
        this.parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            parkingSpaces.add(new ParkingSpace(i, this));
        }
        this.enable = true;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }
    
    public ParkingSpace getParkingSpace(int UIN) {
        for (ParkingSpace space : parkingSpaces) {
            if (space.getUIN() == UIN) {
                return space;
            }
        }
        return null; // If no space with the given UIN is found
    }
    
    public String getName() {
		return name;
	}

	public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}
