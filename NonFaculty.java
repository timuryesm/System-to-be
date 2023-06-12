package SystemToBe;


import java.util.Date;


/**
 *
 * @author 
 */
public class NonFaculty extends Client{
    private boolean validated;
    private String type;

    public NonFaculty(String email, String password) {
        super(email, password);
        type="nonfaculty";
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidation(boolean validated) {
        this.validated = validated;
    }
    
    @Override
    public double getParkingRate() {
        return 10;
    }
    
}
