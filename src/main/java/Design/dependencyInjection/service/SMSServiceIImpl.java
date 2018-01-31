package Design.dependencyInjection.service;

public class SMSServiceIImpl implements  MessagingService{

    @Override
    public void sendMessage() {
        System.out.println("Message sent via SMS");

    }
}
