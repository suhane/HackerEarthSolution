package Design.vendingMachine;

import java.util.List;

public class HasMoneyState implements VendingMachineState {

    VendingMachine vendingMachine;


    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine=vendingMachine;
    }


    public void insertCoinAndSelectProduct(List<Coin> coins, Product product) {
        System.out.println("Machine is busy");

    }

    public void dispenseProduct() {

        System.out.println("Please collect your: "+vendingMachine.getProductSelected());
        vendingMachine.setState(vendingMachine.getNoMoneyState());
    }
}
