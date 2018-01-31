package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 6/17/17.
 */
public class MaxContiguousSum {

    public static long maxSubArray(ArrayList<Integer> a) {

        int l=a.size();
        long max=Integer.MIN_VALUE;
        int max_sum_so_far=a.get(0);
        int max_ending_here=a.get(0);
        int start=0;
        int L=0;
        int R=0;
        for(int i=1;i<l;i++){
            if(a.get(i)>max_ending_here+a.get(i)){
                max_ending_here=a.get(i);
                start=i;
            }
            else{
                max_ending_here=max_ending_here+a.get(i);
            }
            if(max_sum_so_far<=max_ending_here) {
                max_sum_so_far = max_ending_here;
                L=start;
                R=i;
            }
        }
        return max;


    }
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(0);
        a.add(-1);
        a.add(0);//a.add(0);//a.add(-12);a.add(4);a.add(-1);a.add(2);a.add(1);a.add(-5);a.add(4);
        maxSubArray(a);
    }

}
