package Design.atm;

public interface ATMState {

    void insertCard();
    void insertPin(int pin);
    void ejectCard();
    void withdrawCash(int cash);
}
