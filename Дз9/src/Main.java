public class Main {
    public static void main(String[] args) {
        IBeverage myBeverage = new BaseBeverage();
        myBeverage = new MilkDecorator(myBeverage);
        myBeverage = new SugarDecorator(myBeverage);
        myBeverage = new ChocolateDecorator(myBeverage);

        System.out.println("Описание напитка: " + myBeverage.getDescription());
        System.out.println("Стоимость напитка: " + myBeverage.getCost());
    }
}