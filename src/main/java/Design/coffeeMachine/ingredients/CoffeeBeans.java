package Design.coffeeMachine.ingredients;

import Design.coffeeMachine.Coffee;

public class CoffeeBeans extends Ingredients {

    private int units;
    private double cost=0.75;

    public CoffeeBeans(Coffee newCoffee, int units) {
        super(newCoffee);
        this.units=units;

        System.out.println("Adding "+units+" units of coffee");
    }

    @Override
    public String getDescription() {
        return super.getDescription()+","+this.units+" units of Coffee";
    }


    @Override
    public double getCost() {
        return super.getCost()+this.units*this.cost;
    }


}
