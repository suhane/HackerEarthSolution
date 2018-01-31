package Design.pubsub;

public class StockObserver implements Subscriber {

    private double msft;
    private double adbe;
    private double ggog;


    public StockObserver(Publisher stockgrabber){


        stockgrabber.register(this);
    }

    public void update(double msft, double adbe, double goog) {

        this.msft=msft;
        this.adbe=adbe;
        this.ggog=goog;
        System.out.println("Microsft: "+msft+"\nAdobe: "+adbe+"\nGoogle: "+goog+ "\n");
    }
}
