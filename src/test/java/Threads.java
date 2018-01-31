/**
 * Created by suhane on 3/28/17.
 */
public class Threads {

    public static void main(String args[]) throws InterruptedException {
        final Thread septhread=new Thread(new RunningThread());
        septhread.start();
        for (int i=0;i<5;i++){
            System.out.println("Thread running is "+Thread.currentThread().getName());
            Thread.sleep(10000);
        }
    }
}


