package Design.vendingMachine;

public enum Coin {

    One(1),Two(2),Five(5),Ten(10);

    int value;

    private Coin(int v) {
        value=v;
    }
}
