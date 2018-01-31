package interviewBits.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/23/17.
 */
public class MedianOfTwoArrays {
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n=a.size();
        int m=b.size();
        int k=n+m;
        if(k%2==0)
            return (getMedian(a,b,k/2)+getMedian(a,b,k/2+1))/2;
        else
            return getMedian(a,b,(k+1)/2);
    }

    private static double getMedian(List<Integer> a, List<Integer> b, int k) {
        int n=a.size();
        int m=b.size();
        int min=Math.min(n>0?a.get(0):Integer.MAX_VALUE,m>0?b.get(0):Integer.MAX_VALUE);
        int max=Math.max(n>0?a.get(a.size()-1):Integer.MIN_VALUE,m>0?b.get(b.size()-1):Integer.MIN_VALUE);
        int low=min;
        int high=max;
        while(low<high){
            int mid=low+(high-low)/2;
            int places=upperbound(a,mid)+upperbound(b,mid);
            if(places<k)
                low=mid+1;
            else
                high=mid;

        }
        return low;
    }

    private static int upperbound(List<Integer> a, int max) {
        int n=a.size();
        int low=0;
        int high=n-1;

        while(low<=high){
            if(a.get(low)>max)
                return low;
            int mid=low+(high-low)/2;
            if(mid<n-1 && a.get(mid)<=max && a.get(mid+1)>max){
                return mid+1;
            }
            else
                if(a.get(mid)<max)
                    low=mid+1;
            else
                    high=mid-1;

        }
        return n;
    }

    public static void main(String args[]){

        int[] arr1={-50, -41, -40, -19, 5, 21, 28};

        List<Integer> a=new ArrayList<Integer>();

        for(int x:arr1){
            a.add(x);
        }

        int[] arr2={-50, -21, -10};
        List<Integer> b=new ArrayList<Integer>();

        for(int x:arr2){
            b.add(x);
        }
        System.out.print(findMedianSortedArrays(a,b));
    }

}
