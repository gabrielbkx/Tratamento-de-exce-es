package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer romNumber, Date checkin,Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomNumber = romNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Date getCheckin() {
        return checkin;
    }
    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public String updateDates(Date checkin,Date checkout) {
        Date now = new Date();

        if (checkout.before(now) || checkin.before(now)) {
            return "Reservation dates for update must be futures dates";
        }
        if (!checkout.after(checkin)) {
            return "checkout date must be after check in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }
        @Override
        public String toString() {
            return "Room "
                    + roomNumber
                    + ", checkin: "
                    + sdf.format(checkin)
                    + ", checkout: "
                    + sdf.format(checkout)
                    + ", "
                    + duration()
                    + " nights";
        }

    }