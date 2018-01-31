package Design.atm;

public class HasCorrectPin implements ATMState {

    ATMMachine atmMachine;

    public HasCorrectPin(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    public void insertCard() {
        System.out.println("The card is already inserted");
    }

    public void insertPin(int pin) {
        System.out.println("The pin is already correct. Kindly request cash");
    }

    public void ejectCard() {
        System.out.println("Card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCard());
    }

    public void withdrawCash(int cash) {
        if(atmMachine.correctPinEntered) {
            if (cash > atmMachine.cashInMachine) {
                System.out.println("Not enough cash. Card ejected");
            } else {
                System.out.println("Please collect cash");
                atmMachine.setCashInMachine(atmMachine.cashInMachine - cash);
            }
        }
        else {
            System.out.println("Incorrect pin");
        }

        if(atmMachine.cashInMachine<=0)
            atmMachine.setAtmState(atmMachine.getOutOfCash());
        else
            atmMachine.setAtmState(atmMachine.getNoCard());
    }
}
