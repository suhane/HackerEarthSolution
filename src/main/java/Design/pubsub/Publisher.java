package Design.pubsub;

public interface Publisher {

    void register(Subscriber s);
    void deregister(Subscriber s);
    void notifySubscriber();

}
