package Design.coffeeMachine;

import Design.coffeeMachine.ingredients.CoffeeBeans;
import Design.coffeeMachine.ingredients.Cream;
import Design.coffeeMachine.ingredients.Sugar;

public class CoffeeMaker {

    public static void main(String args[]){

        Coffee base= new BaseCoffee(0);
        Coffee coffebeans= new CoffeeBeans(base,3);
        Coffee sugarCoffee=new Sugar(coffebeans,1);
        Coffee creamSugarCoffee= new Cream(sugarCoffee,1);

        System.out.println("Ingredients are: " +creamSugarCoffee.getDescription());
        System.out.println("Cost of the coffee is " +creamSugarCoffee.getCost());
    }
}
