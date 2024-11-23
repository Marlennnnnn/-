public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 5.0; // добавляем стоимость сахара
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Сахар";
    }
}
