package SystemToBe;



/**
 *
 * @author 
 */

public class SuperManager {
	Command command;
    protected String username;
    protected String password;

    protected SuperManager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public ManagementAccounts generateAccount(String username, String password){
    	ParkingSystem parkingSystem = ParkingSystem.getInstance();
    	ManagementAccounts manager = new ManagementAccounts(username, password);;
        parkingSystem.addManager(manager);
        return manager;
    }
    
    public void setCommand(Command comm) {
    	command = comm;
    }
    
    public void executeCommand() {
    	command.execute();
    }
    
    
    
}
