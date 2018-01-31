package Design.dependencyInjection.service;

public class EmailServiceImpl implements  MessagingService{

    @Override
    public void sendMessage() {
        System.out.println("Message sent via Email");
    }
}
