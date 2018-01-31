package Design.pizzadecorator;

public class TomatoSauce  extends PizzaDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Tomato Sauce");
    }

    @Override
    public String getDescription() {
        return super.getDescription()+",Tomato sauce";
    }

    @Override
    public double getCost() {
        return super.getCost()+0.5;
    }
}
