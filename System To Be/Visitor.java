package SystemToBe;


import java.util.Date;

/**
 *
 * @author
 */
public class Visitor extends Client {
	 private String type;
    public Visitor(String email, String password) {
        super(email, password);
        type = "visitor";
    }    
    
    @Override
    public double getParkingRate() {
        return 15;
    }
}
