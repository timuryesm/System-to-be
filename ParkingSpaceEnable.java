package SystemToBe;


public class ParkingSpaceEnable implements Command{
	private int UIN;
    private String location;
    private boolean enabled;
    private ManagementAccounts account;
    
    private Sensor sensor;

    private static int uin_seq = 1;

    public ParkingSpaceEnable(String location, boolean enabled) {
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
		account.enable();
		
	}
}
