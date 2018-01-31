package interviewBits.binarySearch;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by labuser on 7/23/17.
 */
public class PainterPartition {

    public static long paint(int a, int b, ArrayList<Integer> c) {

        long maximumTime=0L;
        for(int el:c){
            maximumTime+= el*1L;
        }

        long low=1L;
        long high=maximumTime;
        long minTime=maximumTime;
        long mid=low+ (high-low)/2;
        while(low<=high){
            if (isPossible(c, a, mid)) {
            minTime = Math.min(mid,minTime);
            high = mid - 1;
        } else low = mid + 1;
        mid=low+ (high-low)/2;
    }

        long ans=(minTime*b*1L) % 10000003;
        return  (int) ans;

    }

    private static boolean isPossible(ArrayList<Integer> c, int b, long max) {
        int _max = max_element(c);
        if(_max > max)
            return false;
        int i=0;
        int n=c.size();
        long sum=0L;
        int cnt=1;
        while(i<n){
            if(sum+c.get(i)>max){
                sum=0;
                cnt++;
            }
            else{
                sum+=c.get(i);
                i++;

            }
        }

        if(cnt>b)
            return false;
        else
            return true;
    }

    private static int max_element(ArrayList<Integer> c) {

        int n= c.size();
        int max=Integer.MIN_VALUE;
        for(int el:c){
            max=Math.max(max,el);
        }
        return max;
    }

    public static void main(String args[]){
        int[] arr={1000000, 1000000};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.println(paint(1,1000000,a));
    }
}
