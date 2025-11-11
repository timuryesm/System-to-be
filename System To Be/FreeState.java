package SystemToBe;

public class FreeState implements ParkingSpaceState {
    public void book(ParkingSpace space) {
        space.setState(new OccupiedState());
    }
    
    public void cancel(ParkingSpace space) {
        System.out.println("This space is already free.");
    }
}