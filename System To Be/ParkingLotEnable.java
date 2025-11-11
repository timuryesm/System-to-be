package SystemToBe;

public class ParkingLotEnable implements Command{
	
	private ManagementAccounts account;
    private String name;
    private boolean enable;

    public ParkingLotEnable(String name) {
        this.name = name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

	@Override
	public void execute() {
		account.enable();
		
	}

}
