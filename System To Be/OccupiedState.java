package SystemToBe;

public class OccupiedState implements ParkingSpaceState {
	@Override
    public void book(ParkingSpace space) {
        System.out.println("This space is already occupied.");
    }
	@Override
    public void cancel(ParkingSpace space) {
        space.setState(new FreeState());
    }
}