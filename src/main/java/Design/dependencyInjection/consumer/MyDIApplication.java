package Design.dependencyInjection.consumer;

import Design.dependencyInjection.service.MessagingService;

public class MyDIApplication implements Consumer{

    private MessagingService messagingService;

    public MyDIApplication(MessagingService messagingService) {
        this.messagingService=messagingService;
    }


    @Override
    public void processMessage() {
        messagingService.sendMessage();
    }
}
