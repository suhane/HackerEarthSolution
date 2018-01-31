package interviewBits.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/22/17.
 */
public class MedianMetrix {

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            min=Math.min(min,A.get(i).get(0));
        for(int i=0;i<n;i++)
            max=Math.max(max,A.get(i).get(m-1));

        int k=(n*m +1)/2;
        while(min<max){
            int mid=min+(max-min)/2;
            int place=0;
            for(int i=0;i<n;i++){
                place+=upperbound(A.get(i),mid);
            }
            if(place<k)
                min=mid+1;
            else
                max=mid;

        }
        return min;

    }

    private static int upperbound(ArrayList<Integer> a, int val) {
        int low=0;
        int n=a.size();
        int high=a.size()-1;
        int largeIndex=0;
        int mid=0;
        if(a.get(high)<=val)
            return n;
        while(low<=high){
            if(a.get(low)>val)
                return low;
            mid = (low + high) / 2;
            int prev = (mid - 1 );
            if (a.get(mid) > val && a.get(prev) <= val)
                return mid;
            if (val >= a.get(mid))
                low = mid + 1;
            else
                high = mid - 1;

        }
        return mid;
    }

    public static void main(String args[]){
        int[] arr={1, 16, 19, 5, 12, 17, 5, 27, 29};
        ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
        int count=0;
        for(int i=0;i<3;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++)
                temp.add(arr[count++]);
            a.add(temp);
        }
        System.out.print(findMedian(a));
    }
}
