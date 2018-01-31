package Design.atm;

public class NoCard implements ATMState {

    ATMMachine atmMachine;
    public NoCard(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    public void insertCard() {
        System.out.println("Card inserted.Please enter the pin");
        atmMachine.setAtmState(atmMachine.hasCard);

    }

    public void insertPin(int pin) {
        System.out.println("Please insert the card first");
    }

    public void ejectCard() {
        System.out.println("Please insert the card first");
    }

    public void withdrawCash(int cash) {

        System.out.println("Please insert the card first");

    }
}
