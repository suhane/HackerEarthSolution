package Design.dependencyInjection.injector;

import Design.dependencyInjection.service.EmailServiceImpl;
import Design.dependencyInjection.consumer.Consumer;
import Design.dependencyInjection.consumer.MyDIApplication;

public class EmailServiceInjector implements MessagingServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }
}
