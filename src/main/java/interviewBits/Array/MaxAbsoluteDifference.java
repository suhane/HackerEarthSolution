package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 6/17/17.
 */
public class MaxAbsoluteDifference {

    public static int maxArr(ArrayList<Integer> a) {

        int max1=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
        int l=a.size();
        for(int i=0;i<l;i++){
            max1=Math.max(a.get(i)-i,max1);
            min1=Math.min(a.get(i)-i,min1);
            max2=Math.max(a.get(i)+i,max2);
            min2=Math.min(a.get(i)+i,min2);
        }

        return Math.max(max1-min1,max2-min2);


    }
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(-1);
        maxArr(a);
    }

}
