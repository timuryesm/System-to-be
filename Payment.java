package SystemToBe;


/**
 *
 * @author
 */
public class Payment {

    /**
     * the parking rates for different types of users are different, i.e., 5$,
     * 8$, 10$, and 15$ for students, faculty members, non-faculty staffs, and
     * visitors per hour respectively.
     *
     * @param hours
     * @param clientType
     * @return
     */
    public double getAmount(int hours, Client clientType) {
        if (clientType instanceof Student) {
            return hours * 5;
        }
        if (clientType instanceof Faculty) {
            return hours * 8;
        }
        if (clientType instanceof NonFaculty) {
            return hours * 10;
        }
        if (clientType instanceof Visitor) {
            return hours * 15;
        }
        return 0;
    }
}
