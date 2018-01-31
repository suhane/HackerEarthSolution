package Design.pizzadecorator;

public class BasicPizza implements Pizza {

    public String getDescription() {
        return "Thin dough";
    }

    public double getCost() {
        return 10.00;
    }
}
