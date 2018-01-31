package concurrency.practical;

/*
In this approach we are dividing the array into n sub-arrays. A task is defined to calculate the sum of sub-array given the
offset and its capacity to process the elements. We are creating n threads and each thread is passed a task with a subarray
The idea is to take the sum here as volatile so we may not get inconsistent results. But unfortunately we are getting inconsistent results
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ArraySumSemaphoresApproach {



    private int[] arr;
    private Semaphore allDone;

    public ArraySumSemaphoresApproach(int[] arr){
        this.arr=arr;
    }

    public void calculateSequentially(){
        int sum=0;
        for(int elem: arr){
            sum+=elem;
        }
        System.out.println(sum);
    }

    public void calculateSumParallely(int numOfThreads) throws InterruptedException {
        int n=arr.length;
        allDone = new Semaphore(0);
        int currSum=0;
        Thread[] threads=new Thread[numOfThreads];
        int threadCapacity= (int) Math.ceil(n/numOfThreads);
        List<Task> tasks= new ArrayList<Task>();
        int start=0;
        int i=0;
        while(start<n){

            int end;
            if(start+threadCapacity>n)
                end=n;
            else
                end=start+threadCapacity;
            Task t= new Task(start,end);
            tasks.add(t);
            threads[i]=new Thread(t);
            start+=threadCapacity;
            threads[i].start();
            i++;
        }

        // Wait to finish (this strategy is an alternative to join())
        try {
            allDone.acquire(numOfThreads);
            // Note: here use acquire(N) ..
            // could instead init semaphore with -9 and use
            // regular acquire() here
        } catch (InterruptedException ignored) {
        }

        for(Task t: tasks){
            currSum+=t.getCurrSum();
        }

        System.out.println(currSum);
    }

    private class  Task implements Runnable {


        private  int currSum;

        public int getCurrSum() {
            return currSum;
        }

        private int end;
        private int start;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public void run() {

            while (start<end) {
                    currSum = currSum + arr[start];
                    start++;
            }
            allDone.release();
            }
        }

}




