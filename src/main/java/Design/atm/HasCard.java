package Design.atm;

public class HasCard implements ATMState {

    ATMMachine atmMachine;

    public HasCard(ATMMachine atmMachine) {
        this.atmMachine=atmMachine;
    }

    public void insertCard() {
        System.out.println("A card is already in the machine");

    }

    public void insertPin(int pin) {

        if(pin==1234){
            System.out.println("Please entered the required cash");
            atmMachine.setCorrectPinEntered(true);
            atmMachine.setAtmState(atmMachine.getHasCorrectPin());
        }
        else{
            System.out.println("Card ejected");
            atmMachine.setAtmState(atmMachine.getNoCard());
        }

    }

    public void ejectCard() {

        System.out.println("Card ejected");
        atmMachine.setAtmState(atmMachine.getNoCard());

    }

    public void withdrawCash(int cash) {

        System.out.println("Please enter pin");

    }
}
