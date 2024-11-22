interface PaymentService {
    boolean processPayment(String user, double amount);
}

class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean processPayment(String user, double amount) {
        System.out.println("Оплата " + amount +  " Прошла");
        return true;
    }
}
