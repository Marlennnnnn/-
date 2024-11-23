public abstract class BeverageDecorator implements IBeverage {
    protected IBeverage beverage;

    public BeverageDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}