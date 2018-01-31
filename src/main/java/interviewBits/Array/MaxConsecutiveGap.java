package interviewBits.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by suhane on 7/4/17.
 */
public class MaxConsecutiveGap {
    public static int maximumGap(final List<Integer> a) {
        int n=a.size();
        if(n<2)
            return 0;
        Collections.sort(a);
        int maxGap=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            maxGap=Math.max(maxGap,a.get(i+1)-a.get(i));
        }
        return maxGap;
    }

    public static void main(String args[]){
        ArrayList<Integer> in= new ArrayList<Integer>();
        int[] array={ 1,10,5,7,15,23,2,9,6,11 };
        for(int x:array){
            in.add(x);
        }
        //in.add(1);//in.add(2);//in.add(2); in.add(4); in.add(5);
        new MaxConsecutiveGap2().maximumGap(in);

    }
}
