package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by labuser on 7/15/17.
 */
public class MinimumPositiveInteger {

    public static int firstMissingPositive(ArrayList<Integer> a) {
        int n=a.size();
        int i=0;


        for(i=0;i<n;i++){
            int val=a.get(i);
            if(val<=0){
                a.remove(i);
                i--;
                n--;
            }

        }

        for(int j=0;j<n;j++){
            if(Math.abs(a.get(j))-1 < n && a.get(Math.abs(a.get(j))-1)>0){
                a.set(Math.abs(a.get(j))-1,-a.get(Math.abs(a.get(j))-1));
            }
        }

        for(int j=0;j<n;j++){
            if(a.get(j)>0){
                return j+1;
            }
        }
        return n+1;
    }

    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(-7);
        a.add(6);
        a.add(8);
        a.add(1);
        a.add(-10);
        a.add(15);

        firstMissingPositive(a);
    }

}
