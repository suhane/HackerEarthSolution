package Design.pubsub;

import java.util.ArrayList;

public class StockGrabber implements Publisher {

    private ArrayList<Subscriber> subscribers;
    private double msft;
    private double adbe;
    private double ggog;

    public void setMsft(double msft) {
        this.msft = msft;
        notifySubscriber();
    }

    public void setAdbe(double adbe) {
        this.adbe = adbe;
        notifySubscriber();
    }

    public void setGgog(double ggog) {
        this.ggog = ggog;
        notifySubscriber();
    }

    public StockGrabber() {
        this.subscribers = new ArrayList<Subscriber>();
    }




    public void register(Subscriber s) {
       System.out.println("Registering Subscriber "+subscribers.size()+1);
        subscribers.add(s);
    }

    public void deregister(Subscriber s) {
        int index=subscribers.indexOf(s);
        System.out.println("De-registering subscriber" + index+1 );
        subscribers.remove(index);
    }

    public void notifySubscriber() {

        for(Subscriber subscriber: subscribers){
            subscriber.update(msft,adbe,ggog);
        }

    }
}
