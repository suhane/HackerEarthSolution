package Design.dependencyInjection.injector;

import Design.dependencyInjection.service.SMSServiceIImpl;
import Design.dependencyInjection.consumer.Consumer;
import Design.dependencyInjection.consumer.MyDIApplication;

public class SMSServiceInjector implements MessagingServiceInjector {

    @Override
    public Consumer getConsumer() {

        return new MyDIApplication(new SMSServiceIImpl());
    }
}
