package Design.vendingMachine;

public enum Product {

    PEPSI(10),COKE(15),SODA(10),APPY(20);

    int value;

    private Product(int v){
        this.value=v;
    }
}
