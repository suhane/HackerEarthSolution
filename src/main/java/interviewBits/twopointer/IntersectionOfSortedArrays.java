package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/25/17.
 */
public class IntersectionOfSortedArrays {
    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int n=a.size();
        int m=b.size();
        ArrayList<Integer> output= new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<n && j<m){
            int val1=a.get(i);
            int val2=b.get(j);
            if(val1==val2){
                output.add(a.get(i));
                i++;
                j++;
            }
            else if(val1<val2)
                i++;
            else
                j++;
        }
        return output;


    }

    public  static void main(String args[]){
        int[] arr={12, 30, 41, 51, 56, 58, 63, 67, 82, 90, 93};
        List<Integer> A=new ArrayList<Integer>();

        for(int x:arr){
            A.add(x);
        }

        List<Integer> B=new ArrayList<Integer>();

        int[] arr1={7, 9, 17, 17, 19, 21, 26, 34, 65, 65, 67, 68, 71, 75, 92};
        for(int x:arr1){
            B.add(x);
        }

        System.out.print(intersect(A,B));
    }
}
