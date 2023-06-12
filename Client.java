package SystemToBe;


import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author
 */
public abstract class Client {

    protected String email;
    protected String password;
    protected String licensePlate;
    protected ParkingSpace space;
    protected int hour;
    protected String type;
    
    
    public String getEmail() {
		return email;
	}
    
    public String getType() {
		return type;
	}

	public String getPassword() {
		return password;
	}


	protected double amount;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
        this.licensePlate = "";
        this.space = null;
        this.hour = 0;
        this.amount = 0;
    }
    
    public abstract double getParkingRate();

    public static boolean isEmailValid(String email) {
        email = email.trim();
        if (email == null || email.length() < 3
                || email.contains("@") == false) {
            return false;
        }

        // only allow underscore, hyphen, dot, numeric values, @ and letter
        for (char ch : email.toCharArray()) {
            if (Character.isLetterOrDigit(ch) == false
                    && ch != '_' && ch != '-'
                    && ch != '.' && ch != '@') {
                return false;
            }
        }

        String[] sp = email.split("@");
        // only one @ is allowed
        if (sp.length != 2) {
            return false;
        }
        // For the local part, a maximum of 64 characters are allowed.
        for (String string : sp) {
            if (string.length() > 64) {
                return false;
            }
        }
        // Dot isn't allowed at the start and end of the local part.
        String first = sp[0];
        String last = sp[1];
        if (first.charAt(0) == '.' || last.charAt(0) == '.'
                || first.charAt(first.length() - 1) == '.'
                || last.charAt(last.length() - 1) == '.') {
            return false;
        }
        return true;
    }

    public static boolean isPasswordValid(String password) {
        /**
         *
         *
         * An English uppercase character (A-Z)
         *
         * An English lowercase character (a-z)
         *
         * A number (0-9) and/or symbol (such as !, #, or %)
         *
         * Ten or more characters total.
         *
         */
        boolean lower = false;
        boolean upper = false;
        boolean number = false;
        String symbols = "!#%@";
        boolean symbol = false;
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower = true;
            }
            if (Character.isUpperCase(ch)) {
                upper = true;
            }
            if (Character.isDigit(ch)) {
                number = true;
            }
            if (symbols.contains(ch + "")) {
                symbol = true;
            }
        }
        return lower && upper && number && symbol
                && password.length() >= 10;
    }

    /**
     * the parking rates for different types of users are different, i.e., 5$,
     * 8$, 10$, and 15$ for students, faculty members, non-faculty staffs, and
     * visitors per hour respectively.
     *
     * @param licensePlate
     * @param space
     * @param startTime
     * @param amount
     * @return
     */
    public Booking doBooking(String licensePlate, ParkingSpace space,
            Date startTime, double amount) {
        /**
         * Req4: Booking a parking space requires the cost of an hour (of the
         * type of a client) as the deposit, which will not be refunded if a
         * no-show happens in the first 1 hour of the booked parking period.
         * Otherwise, the deposit will be deducted when checking out.
         */
        int hour = 1;
        /**
         * Req8: To book a parking space, clients need to provide a valid
         * licence plate number. A client can edit or cancel her/his bookings
         * before the starting time of a booking.
         */
        return new Booking(licensePlate, space, startTime, hour, amount);
    }

}
