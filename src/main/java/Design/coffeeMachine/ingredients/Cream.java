package Design.coffeeMachine.ingredients;

import Design.coffeeMachine.Coffee;

public class Cream extends Ingredients {

    private int units;
    private double cost=0.25;

    public Cream(Coffee newCoffee, int units) {
        super(newCoffee);
        this.units=units;

        System.out.println("Adding "+units+" units of cream");
    }

    @Override
    public String getDescription() {
        return super.getDescription()+","+this.units+" units of cream";
    }


    @Override
    public double getCost() {
        return super.getCost()+this.units*this.cost;
    }
}
