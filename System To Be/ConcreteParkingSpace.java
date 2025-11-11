package SystemToBe;

import java.util.ArrayList;
import java.util.List;

public class ConcreteParkingSpace implements Observer {
	
    private boolean isOccupied;
    private String carInfo;
    private List<Sensor> sensors = new ArrayList<>();

    public void setOccupied(boolean isOccupied, String carInfo) {
        this.isOccupied = isOccupied;
        this.carInfo = carInfo;
        notifyObservers();
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    
    public String getCarInfo(){
        return carInfo;
    }
    
    public void notifyObservers() {
        for (Sensor sensor : sensors) {
            sensor.update(this);
        }
    }

	public void attach(Sensor observer) {
		sensors.add(observer);
		
	}

	public void detach(Sensor observer) {
		sensors.remove(observer);
		
	}
}
