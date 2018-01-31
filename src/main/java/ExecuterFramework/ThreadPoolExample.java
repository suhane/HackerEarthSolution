package ExecuterFramework;

import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String args[]){
        ExecutorService service= Executors.newFixedThreadPool(10);
        for (int i =0; i<100; i++){
            service.submit(new Task(i));
        }
        service.shutdown();
    }
}


final class Task implements  Runnable{

    private int taskId;

    public Task(int id){
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by "
                        + Thread.currentThread().getName());

    }
}