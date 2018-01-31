package Design.atm;

public class OutofCash implements ATMState {

    ATMMachine atmMachine;

    public OutofCash(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    public void insertCard() {

        System.out.println("ATM is out of cash");
    }

    public void insertPin(int pin) {
        System.out.println("ATM is out of cash");
    }

    public void ejectCard() {

        System.out.println("ATM is out of cash");
    }

    public void withdrawCash(int cash) {
        System.out.println("ATM is out of cash");
    }
}
