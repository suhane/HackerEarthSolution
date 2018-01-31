package Design.coffeeMachine.ingredients;

import Design.coffeeMachine.Coffee;

public abstract class Ingredients implements Coffee {

    private Coffee coffee;

    public Ingredients(Coffee newCoffee){
        this.coffee=newCoffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }


    public double getCost() {
        return coffee.getCost();
    }
}
