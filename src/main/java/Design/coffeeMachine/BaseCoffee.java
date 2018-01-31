package Design.coffeeMachine;

public class BaseCoffee implements Coffee {

    private int units;
    private double cost=1.00;

    public BaseCoffee(int units){
        this.units=units;
    }

    public String getDescription() {
        return "base";
    }

    public double getCost() {
        return this.units*this.cost;
    }
}
