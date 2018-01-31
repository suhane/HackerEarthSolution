package Design.pizzadecorator;

public class Mozzarella extends PizzaDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding dough");
        System.out.println("Adding Mozzarella cheese");
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", Mozzarella";
    }

    @Override
    public double getCost() {
        return super.getCost()+0.35;
    }
}
