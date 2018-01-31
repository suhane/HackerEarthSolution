/**
 * Created by suhane on 3/28/17.
 */
public class RunningThread implements Runnable {
    @Override
    public void run() {

        for(int i=0;i<5;i++){
            System.out.println("Thread running is "+Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
