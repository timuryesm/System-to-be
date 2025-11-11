package SystemToBe;


public class ParkingSpaceDisable implements Command{
	private int UIN;
    private String location;
    private boolean enabled;
    private ManagementAccounts account;
    
    private Sensor sensor;

    private static int uin_seq = 1;

    public ParkingSpaceDisable(String location, boolean enabled) {
        this.UIN = uin_seq;
        this.location = location;
        this.enabled = enabled;
        uin_seq++;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
	
	
	public void execute() {
		account.disable();
		
	}
}
