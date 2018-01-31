package ExecuterFramework;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String args[]) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(5);
        System.out.println("Current Time = "+new Date());
        for(int i=0;i<3;i++){
            //Thread.sleep(1000);
            Worker worker = new Worker("do heavy processing");
            scheduledExecutorService.scheduleAtFixedRate(worker,0,10, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();


    }
}

class Worker implements Runnable{

    String command;

    public Worker(String id){
        this.command=id;
    }

    @Override
    public String toString() {
        return this.command;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
    }

    private void processCommand() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


