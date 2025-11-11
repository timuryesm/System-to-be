package SystemToBe;

public interface Observer {
	
	void attach(Sensor sensor);

    void detach(Sensor sensor);

    void notifyObservers();

	boolean isOccupied();

	String getCarInfo();

}
