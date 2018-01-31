package Design.coffeeMachine.states;

import Design.coffeeMachine.Beverage;
import Design.coffeeMachine.ingredients.Ingredient;

public interface CoffeeMachineState {

    void selectDrink(Beverage beverage);
    void selectIngredient(Ingredient ingredient, int units);
    void dispenseCoffee();
    void quit();
    void restock(Ingredient ingredient);
}
