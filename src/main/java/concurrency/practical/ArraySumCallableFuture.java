package concurrency.practical;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ArraySumCallableFuture {

    private int[] arr;

    public ArraySumCallableFuture(int[] arr){
        this.arr=arr;
    }


    public void calculateSumParallely(int numOfThreads) throws InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(numOfThreads);
        int n=arr.length;
        int currSum=0;
        int threadCapacity= (int) Math.ceil(n/numOfThreads);
        List<Task> tasks= new ArrayList<>();
        List<Future<Integer>> futures= new ArrayList<>();
        int start=0;
        while(start<n){

            int end;
            if(start+threadCapacity>n)
                end=n;
            else
                end=start+threadCapacity;
            Task t= new Task(start,end);
            futures.add(service.submit(t));
            tasks.add(t);
            start+=threadCapacity;
        }

        service.shutdown();
        while (!service.isTerminated()) {}
        for (Future<Integer> f : futures) {
            try {
                currSum += f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        System.out.println(currSum);
    }

    private class  Task implements Callable<Integer> {


        private  int currSum;
        private int end;
        private int start;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public Integer call() {

            while (start<end) {
                currSum = currSum + arr[start];
                start++;
            }
            return currSum;
        }
    }
}
