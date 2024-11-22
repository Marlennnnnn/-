interface NotificationService {
    void sendNotification(String user, String message);
}

class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String user, String message) {
        System.out.println("Уведомление отправлено по адресу " + user + ": " + message);
    }
}
