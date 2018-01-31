package Design.dispatch;

import java.util.ArrayList;
import java.util.List;

public class CallHandler {


    private static CallHandler instance;
    /* Initialize 10 respondents, 4 managers, and 2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> handlers;

    protected CallHandler(){

        if(instance!=null)
            throw  new IllegalStateException("Instance is already initialised");

        handlers=new ArrayList<List<Employee>>();
        handlers.add(new ArrayList<Employee>());
        handlers.add(new ArrayList<Employee>());
        handlers.add(new ArrayList<Employee>());


        for(int i = 0; i < 10; i++) {
            Respondent respondent = new Respondent(i + 1, "respondent", 20);
            handlers.get(0).add(respondent);
        }
        for(int i = 0; i < 3; i++) {
            Manager manager = new Manager(i + 1, "manager", 20);
            handlers.get(0).add(manager);
        }
        for(int i = 0; i < 1; i++) {
            Director director = new Director(i + 1, "director", 20);
            handlers.get(0).add(director);
        }



    }

    public static CallHandler getInstance(){
        if(instance==null)
            instance=new CallHandler();
        return instance;
    }

    private Employee getHandlerForCall(Call call) {
        int level=call.getRank().value;

        List<Employee> allotedHandlers=handlers.get(level);
        for(Employee handler: allotedHandlers){
            if(handler.available)
                return handler;
        }

        return null;
    }

    public void dispatchCall(Call call) {
        Employee handler=getHandlerForCall(call);
        if(handler!=null){
            handler.getCall(call);
            call.setHandler(handler);
        }
        else {
           call.reply("All our responders are busy. You are in queue");

        }

    }



}
