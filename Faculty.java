package SystemToBe;


import java.util.Date;


/**
 *
 * @author
 */
public class Faculty extends Client {
 private boolean validated;
 private String type;

    public Faculty(String email, String password) {
        super(email, password);
        type = "faculty";
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidation(boolean validated) {
        this.validated = validated;
    }
    
    @Override
    public double getParkingRate() {
        return 8;
    }
    
}
