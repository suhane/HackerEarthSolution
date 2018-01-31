package concurrency;

/**
 * Created by suhane on 6/25/17.
 */
public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }


    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(10000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                msg.notify();
                 //msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
