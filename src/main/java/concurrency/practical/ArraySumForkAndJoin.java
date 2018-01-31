package concurrency.practical;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


    public class ArraySumForkAndJoin extends RecursiveTask<Integer> {


        private int threshold=10000;
        private int arr[];
        private int lo;
        private int hi;
        public ArraySumForkAndJoin( int arr[], int i,int j){
            this.arr=arr;
            lo=i;
            hi=j;
        }
        @Override
        protected Integer compute() {

            if(hi-lo<=threshold){
                int ans=0;
                for(int i=lo;i<hi;i++){
                    ans=ans+arr[i];
                }
                return ans;
            }

            else{
                int mid=(lo+hi)/2;
                ArraySumForkAndJoin left = new ArraySumForkAndJoin(arr, lo, mid);
                ArraySumForkAndJoin right = new ArraySumForkAndJoin(arr, mid, hi);
                left.fork();
                int sumRight=right.compute();
                int leftSum=left.join();

                return sumRight+leftSum;
            }
        }


}
