import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Hotel {
    private String name;
    private String location;
    private String roomType;
    private double price;

    public Hotel(String name, String location, String roomType, double price) {
        this.name = name;
        this.location = location;
        this.roomType = roomType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Hotel: %s, Location: %s, Room: %s, Price: %.2f", name, location, roomType, price);
    }
}

interface HotelService {
    List<Hotel> searchHotels(String location, String roomType, double maxPrice);
}

class HotelServiceImpl implements HotelService {
    private List<Hotel> hotels = new ArrayList<>();

    public HotelServiceImpl() {
        hotels.add(new Hotel("Grand Plaza", "Paris", "Deluxe", 150.0));
        hotels.add(new Hotel("Sea View", "Barcelona", "Standard", 100.0));
        hotels.add(new Hotel("Mountain Retreat", "Geneva", "Suite", 200.0));
    }

    @Override
    public List<Hotel> searchHotels(String location, String roomType, double maxPrice) {
        return hotels.stream()
                .filter(h -> h.getLocation().equalsIgnoreCase(location) &&
                        h.getRoomType().equalsIgnoreCase(roomType) &&
                        h.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}
