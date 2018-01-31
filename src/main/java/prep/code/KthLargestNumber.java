package prep.code;

import java.util.PriorityQueue;

public class KthLargestNumber {

    public int findKthLargestPQ(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int val : nums) {
            pq.offer(val);
            /*
            if(pq.size() > k) {
                pq.poll();
            }
            */
        }
        while (pq.size()!=5)
            pq.poll();
        return pq.peek();
    }


    public int findKthLargest(int[] nums, int low, int high, int k) {

        if(k>0 && k<=high-low+1) {
            int pos = partition(nums, low, high);
            if (pos - low == k - 1)
                return nums[pos];
            if (pos - low > k - 1)
                return findKthLargest(nums, low, pos - 1, k);
            return findKthLargest(nums, pos + 1, high,  k-pos - 1 + low);
        }
        return Integer.MAX_VALUE;
    }

    private int partition(int[] a, int lo, int hi) {

        int i=lo;
        int x=a[hi];
        int j;
        for(j=lo;j<hi;j++){

            if(a[j]<=x){
                exch(a,i,j);
                i++;
            }
        }
        exch(a,i,hi);
        return i;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String args[]){
        int[] nums={6,11,3,4,1,78,2,5,10,1000,15,22};
        System.out.println(new KthLargestNumber().findKthLargest(nums,0,nums.length-1,11));



    }
}
