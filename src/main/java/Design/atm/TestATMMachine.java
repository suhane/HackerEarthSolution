package Design.atm;

public class TestATMMachine {

    public static void main(String[] args){

        ATMMachine atmMachine = new ATMMachine();


        atmMachine.insertCard();

        atmMachine.ejectCard();

        atmMachine.insertCard();

        atmMachine.insertPin(1234);

        atmMachine.withdrawCash(2000);

        atmMachine.insertCard();

        atmMachine.insertPin(1234);

    }
}
