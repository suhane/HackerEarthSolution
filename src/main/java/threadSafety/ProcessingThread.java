package threadSafety;

/**
 * Created by suhane on 6/26/17.
 */
class ProcessingThread implements Runnable{
    private int count;

    private Object mutex=new Object();


    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
            synchronized (mutex) {
                count++;
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}