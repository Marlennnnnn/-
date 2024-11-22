import java.util.ArrayList;
import java.util.List;

class Booking {
    private String user;
    private Hotel hotel;
    private String startDate;
    private String endDate;

    public Booking(String user, Hotel hotel, String startDate, String endDate) {
        this.user = user;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Booking: %s, User: %s, From: %s, To: %s", hotel, user, startDate, endDate);
    }
}

interface BookingService {
    boolean bookHotel(String user, Hotel hotel, String startDate, String endDate);
    List<Booking> getBookings();
}

class BookingServiceImpl implements BookingService {
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public boolean bookHotel(String user, Hotel hotel, String startDate, String endDate) {
        bookings.add(new Booking(user, hotel, startDate, endDate));
        System.out.println("Отель успешно забронирован!");
        return true;
    }

    @Override
    public List<Booking> getBookings() {
        return bookings;
    }
}
