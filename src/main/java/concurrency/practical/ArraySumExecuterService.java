package concurrency.practical;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArraySumExecuterService {

    private int[] arr;

    public ArraySumExecuterService(int[] arr){
        this.arr=arr;
    }

    public void sumParallely(int numOfThreads){

        ExecutorService service= Executors.newFixedThreadPool(numOfThreads);
        int n=arr.length;
        int currSum=0;
        int threadCapacity= (int) Math.ceil(n/numOfThreads);
        List<Task> tasks= new ArrayList<>();
        int start=0;
        while(start<n){

            int end;
            if(start+threadCapacity>n)
                end=n;
            else
                end=start+threadCapacity;
            Task t= new Task(start,end);
            service.submit(t);
            tasks.add(t);
            start+=threadCapacity;
        }

        service.shutdown();
        while (!service.isTerminated()) {}
            for (Task t : tasks) {
                currSum += t.getCurrSum();
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
        }
    }
}
