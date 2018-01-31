package Design.coffeeMachine.ingredients;

import Design.coffeeMachine.Coffee;

public class Sugar extends Ingredients {

    private int units;
    private double cost=0.25;

    public Sugar(Coffee newCoffee, int units) {
        super(newCoffee);
        this.units=units;

        System.out.println("Adding "+units+" units of sugar");
    }

    @Override
    public String getDescription() {
        return super.getDescription()+","+this.units+" units of sugar";
    }


    @Override
    public double getCost() {
        return super.getCost()+this.units*this.cost;
    }
}
