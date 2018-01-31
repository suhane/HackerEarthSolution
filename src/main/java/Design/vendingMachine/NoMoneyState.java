package Design.vendingMachine;

import java.util.List;

public class NoMoneyState implements VendingMachineState {

    VendingMachine vendingMachine;


    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine=vendingMachine;
    }

    public void insertCoinAndSelectProduct(List<Coin> coins, Product product) {
        int sum=0;
        for(Coin coin:coins){
            sum+=coin.value;
        }
        if(sum==product.value){
            System.out.println("Coins accepted");
            vendingMachine.setState(vendingMachine.getHasMoneyState());
        }
    }

    public void dispenseProduct() {
        System.out.println("Please insert coins and select product");
    }
}
