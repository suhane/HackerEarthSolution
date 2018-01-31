package interviewBits.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/23/17.
 */
public class RotatedArraySearch {

    public static int search(final List<Integer> a, int b) {
        int n=a.size();
        int min= searchMin(a);
        if(a.get(n-1)>b)
            return searchSubArray(a,min,n-1,b);
        else
            return searchSubArray(a,0,min-1,b);

        }

    private static int searchMin(List<Integer> a) {
        int low=0;
        int n=a.size();
        int high=n-1;
        while(low<=high){
            if(a.get(low)<a.get(high))
                return low;
            int mid=low+(high-low)/2;
            int next=(mid+1)%n;
            int prev=(mid-1+n)%n;
            if(a.get(prev)>a.get(mid) && a.get(next)>a.get(mid))
                return mid;
            else if(a.get(mid)>a.get(low))
                low=mid+1;
            else
                high=mid-1;
        }
        return 0;
    }

    private static int searchSubArray(List<Integer> a, int low, int high, int b) {
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a.get(mid)==b)
                return mid;
            else
                if(b<a.get(mid))
                    high=mid-1;
            else
                    low=mid+1;
        }
        return -1;
    }

    public static void main(String args[]){

        int[] arr={4 ,5 ,6, 7, 0, 1 ,2};
        List<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.print(search(a,17));
    }
}
