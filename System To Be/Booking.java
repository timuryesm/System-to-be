package SystemToBe;


import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author
 */
public class Booking {

    private String licensePlace;
    private ParkingSpace space;
    private Date startTime;
    private int hour;
    private double amount;

    public Booking(String licensePlace, ParkingSpace space, Date startTime, int hour, double amount) {
        this.licensePlace = licensePlace;
        this.space = space;
        this.startTime = startTime;
        this.hour = hour;
        this.amount = amount;
        space.book();
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    public int getHour() {
        return hour;
    }

    public static void editBooking(Date startTime, Booking booking) {
        if (startTime != null && booking != null) {
            booking.startTime = startTime;
        }
    }

    public static void cancelBooking(Booking booking) {
        if (booking != null) {
            booking.licensePlace = null;
            booking.space = null;
            booking.startTime = null;
            booking.hour = 0;
            booking.amount = 0.0;
        }
    }

    public static void extendBooking(int hours, Booking booking) {
        if (booking != null) {
            /**
             * Req9: Clients can extend a parking time before the expiration
             */
        	booking.hour += hours;
        }
    }

	public String getLicensePlace() {
		return licensePlace;
	}

	public String getSpace() {
		return space.getLocation();
	}

	public double getAmount(Booking booking) {
		return amount*booking.getHour();
	}
	
	public void cancel() {
        space.cancel();
    }
}
