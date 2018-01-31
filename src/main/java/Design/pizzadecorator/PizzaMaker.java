package Design.pizzadecorator;

public class PizzaMaker {

    public static void main(String args[]){

        Pizza myPizza= new TomatoSauce(new Mozzarella(new BasicPizza()));
        System.out.println("Ingredients are: "+myPizza.getDescription());
        System.out.println("The cost of pizza is "+myPizza.getCost());


    }
}
