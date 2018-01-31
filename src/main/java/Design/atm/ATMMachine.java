package Design.atm;

public class ATMMachine implements ATMState{

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState outOfCash;
    ATMState atmState;

    boolean correctPinEntered=false;
    int cashInMachine=200000;

    public ATMMachine() {
        this.hasCard = new HasCard(this);
        this.noCard = new NoCard(this);
        this.hasCorrectPin=new HasCorrectPin(this);
        this.outOfCash=new OutofCash(this);

        this.atmState=noCard;
        if(this.cashInMachine<0)
            this.atmState=outOfCash;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    public void setCorrectPinEntered(boolean correctPinEntered) {
        this.correctPinEntered = correctPinEntered;
    }

    /*

    concrete state getters
     */

    public ATMState getHasCard() {
        return hasCard;
    }

    public ATMState getNoCard() {
        return noCard;
    }

    public ATMState getHasCorrectPin() {
        return hasCorrectPin;
    }

    public ATMState getOutOfCash() {
        return outOfCash;
    }

    /*
        atm State getter
     */

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }


    public void insertCard() {
        atmState.insertCard();
    }

    public void insertPin(int pin) {
        atmState.insertPin(pin);
    }

    public void ejectCard() {
        atmState.ejectCard();
    }

    public void withdrawCash(int cash) {
        atmState.withdrawCash(cash);
    }
}
