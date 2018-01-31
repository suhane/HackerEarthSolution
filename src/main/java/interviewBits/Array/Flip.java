package interviewBits.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhane on 6/17/17.
 */
public class Flip {

    public static ArrayList<Integer> flip(String A) {

                ArrayList<Integer> out= new ArrayList<Integer>();
                int n = A.length();
                int start=0;
                int L=0;
                int R=0;
                int max_sum_so_far=Integer.MIN_VALUE;
                int max_sum_ending_here=0;
                boolean perfectString=true;
                for(int i=0;i<n;i++){
                    if(A.charAt(i)=='0')
                        perfectString=false;
                    max_sum_ending_here=getBit(A,i)+max_sum_ending_here;
                    if(max_sum_ending_here<0){
                        start=i+1;
                        max_sum_ending_here=0;
                    }
                    if(max_sum_so_far< max_sum_ending_here){

                        max_sum_so_far=max_sum_ending_here;
                        L=start;
                        R=i;
                    }
                }

            if(perfectString)
                return out;

            out.add(L+1);
            out.add(R+1);

            return out;

    }

    private static int getBit(String s, int index){
        return s.charAt(index)=='1'?-1:1;
    }
    public static void main(String args[]){
        flip("010");
    }

}
