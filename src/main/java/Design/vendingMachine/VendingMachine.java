package Design.vendingMachine;

import java.util.List;

public class VendingMachine {

    private VendingMachineState state;
    private VendingMachineState hasMoneyState;
    private VendingMachineState noMoneyState;
    private Product productSelected;

    public void setProductSelected(Product productSelected) {
        this.productSelected = productSelected;
    }

    public Product getProductSelected() {
        return this.productSelected;
    }

    public VendingMachine() {

        this.hasMoneyState=new HasMoneyState(this);
        this.noMoneyState=new NoMoneyState(this);

        this.state=noMoneyState;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public void insertAndSelectProduct(List<Coin> coins, Product p){
        state.insertCoinAndSelectProduct(coins,p);
    }

    public void dispenseProduct(){
        state.dispenseProduct();
    }
}
