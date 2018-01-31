package Design.pubsub;

public class PubsubTest {


    public static void main(String args[]){

        StockGrabber stockgrabber= new StockGrabber();

        Subscriber s=new StockObserver(stockgrabber);
        stockgrabber.register(s);
        stockgrabber.setAdbe(23.23);
        stockgrabber.setMsft(12.23);
        stockgrabber.setGgog(12.34);

    }
}
