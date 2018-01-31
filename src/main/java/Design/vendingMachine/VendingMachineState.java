package Design.vendingMachine;

import java.util.List;

public interface VendingMachineState {

    void insertCoinAndSelectProduct(List<Coin> coins, Product product);
    void dispenseProduct();

}
