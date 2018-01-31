package Design.coffeeMachine.states.impl;

import Design.coffeeMachine.Beverage;
import Design.coffeeMachine.CoffeeMachine;
import Design.coffeeMachine.ingredients.Ingredient;
import Design.coffeeMachine.states.CoffeeMachineState;

public class ProductSelectedState implements CoffeeMachineState {

    CoffeeMachine coffeeMachineine;

    public ProductSelectedState(CoffeeMachine coffeeMachine) {
        this.coffeeMachineine=coffeeMachine;
    }

    public void selectDrink(Beverage beverage) {

    }

    public void selectIngredient(Ingredient ingredient, int units) {

    }

    public void dispenseCoffee() {

    }

    public void quit() {

    }

    public void restock(Ingredient ingredient) {

    }
}
