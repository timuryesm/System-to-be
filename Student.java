package SystemToBe;


import java.util.Date;


/**
 *
 * @author
 */
public class Student extends Client {

    private boolean validated;
    private String type;

    public Student(String email, String password) {
        super(email, password);
        type ="student";
        
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidation(boolean validated) {
        this.validated = validated;
    }
    
    @Override
    public double getParkingRate() {
        return 5;
    }
}
