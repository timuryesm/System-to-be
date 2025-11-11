package SystemToBe;


/**
 *
 * @author
 */
public class ParkingSpace {

    /**
     * Req7: Each parking space will have a unique identification number and
     * other details including its location and its parting lot, which will help
     * with the navigation for clients
     */
    private int UIN;
    private String location;
    private Parkinglot lot;
    private boolean enabled;
    private ParkingSpaceState state;
    
    /**
     * Req5: Suppose each parking space has a sensor to detect if a car is using
     * the parking space or not. In addition, the sensor can also scan the basic
     * info of cars, and further send the essential information to the system.
     */
    private Sensor sensor;

    public ParkingSpace(int UIN, Parkinglot lot) {
        this.UIN = UIN;
        this.location = " "+lot+UIN;
        this.lot = lot;
        this.enabled = true;
        this.state = new FreeState();
    }

    /**
     * Req6: Managers of the system can add, enable, or disable a parking lot, a
     * parking lot contains 100 parking spaces. Managers can also enable or
     * disable a parking space due to maintenance issues.
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getUIN() {
        return UIN;
    }
    
	public String getLocation() {
		return location;
	}
	
    public void book() {
        state.book(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void setState(ParkingSpaceState state) {
        this.state = state;
    }
    

}
