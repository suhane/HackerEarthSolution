package Design.coffeeMachine.states.impl;
import Design.coffeeMachine.BaseCoffee;
import Design.coffeeMachine.Beverage;
import Design.coffeeMachine.CoffeeMachine;
import Design.coffeeMachine.ingredients.Ingredient;
import Design.coffeeMachine.states.CoffeeMachineState;

public class NoProductSelectedState implements CoffeeMachineState {

    CoffeeMachine coffeeMachine;

    public NoProductSelectedState(CoffeeMachine coffeeMachine){
        this.coffeeMachine=coffeeMachine;
    }

    public void selectDrink(Beverage beverage) {

    }

    public void selectIngredient(Ingredient ingredient, int units) {

    }

    public void dispenseCoffee() {
        System.out.println("Please select a drink first");
    }

    public void quit() {

        System.out.println("Operation cancelled. Thank you!!!!");
        coffeeMachine.setBaseCoffee(new BaseCoffee(0));
        coffeeMachine.setCoffeMachineState(coffeeMachine.getNoSelectionState());

    }

    public void restock(Ingredient ingredient) {

    }
}
