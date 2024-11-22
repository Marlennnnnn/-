import java.util.Scanner;

public class HotelBookingSystem {
    public static void main(String[] args) {
        UserManagementService userService = new UserManagementServiceImpl();
        HotelService hotelService = new HotelServiceImpl();
        BookingService bookingService = new BookingServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();
        NotificationService notificationService = new NotificationServiceImpl();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать!");
        System.out.print("Зарегистрируйтесь (r) или Войдите в систему (l)");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("r")) {
            System.out.print("Имя: ");
            String username = scanner.nextLine();
            System.out.print("Пороль: ");
            String password = scanner.nextLine();
            userService.registerUser(username, password);
        }

        System.out.print("Имя: ");
        String username = scanner.nextLine();
        System.out.print("Пороль: ");
        String password = scanner.nextLine();

        if (userService.loginUser(username, password)) {
            System.out.print("Введите местоположение: ");
            String location = scanner.nextLine();
            System.out.print("Номер комнаты: ");
            String roomType = scanner.nextLine();
            System.out.print("Введите максимальную цену: ");
            double maxPrice = scanner.nextDouble();

            System.out.println("Поиск отелей...");
            var hotels = hotelService.searchHotels(location, roomType, maxPrice);
            hotels.forEach(System.out::println);

            System.out.println("Бронируем первый отель...");
            Hotel hotel = hotels.get(0);
            bookingService.bookHotel(username, hotel, "2024-11-25", "2024-11-30");
            paymentService.processPayment(username, hotel.getPrice());
            notificationService.sendNotification(username, "Ваше бронирование подтверждено!");

            System.out.println("Все бронирования:");
            bookingService.getBookings().forEach(System.out::println);
        }
    }
}
