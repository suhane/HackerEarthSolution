package Design.dependencyInjection;

import Design.dependencyInjection.consumer.Consumer;
import Design.dependencyInjection.injector.EmailServiceInjector;
import Design.dependencyInjection.injector.MessagingServiceInjector;
import Design.dependencyInjection.injector.SMSServiceInjector;

public class DITest {

    public static void main(String[] s){

        MessagingServiceInjector injector = null;
        Consumer app = null;

        injector=new EmailServiceInjector();
        app=injector.getConsumer();
        app.processMessage();

        injector=new SMSServiceInjector();
        app=injector.getConsumer();
        app.processMessage();

    }
}
