package Design.coffeeMachine;

import Design.coffeeMachine.states.CoffeeMachineState;
import Design.coffeeMachine.states.impl.NoProductSelectedState;
import Design.coffeeMachine.states.impl.ProductSelectedState;

public class CoffeeMachine {

    CoffeeMachineState coffeMachineState;
    Coffee baseCoffee;

    public Coffee getBaseCoffee() {
        return baseCoffee;
    }

    public void setBaseCoffee(Coffee baseCoffee) {
        this.baseCoffee = baseCoffee;
    }



    public void setCoffeMachineState(CoffeeMachineState coffeMachineState) {
        this.coffeMachineState = coffeMachineState;
    }

    CoffeeMachineState noSelectionState;
    CoffeeMachineState productSelectedState;

    public CoffeeMachineState getProductSelectedState() {
        return productSelectedState;
    }

    public CoffeeMachineState getNoSelectionState() {
        return noSelectionState;
    }

    public CoffeeMachine(){

        this.noSelectionState=new NoProductSelectedState(this);
        this.productSelectedState=new ProductSelectedState(this);
        this.baseCoffee=new BaseCoffee(0);
        this.coffeMachineState=this.noSelectionState;

    }





}
