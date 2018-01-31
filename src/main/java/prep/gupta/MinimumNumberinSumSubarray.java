package prep.gupta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumNumberinSumSubarray {

    public static int solve(ArrayList<Integer> a){

        Collections.sort(a);
            int res = 1; // Initialize result
            int n=a.size();

            // Traverse the array and increment 'res' if arr[i] is
            // smaller than or equal to 'res'.
            for (int i = 0; i < n && a.get(i) <= res; i++)
                res = res + a.get(i);

            return res;
        }




    public static void main(String args[]){
        ArrayList<Integer> l= new ArrayList<Integer>(Arrays.asList(1, 2, 6, 10, 11, 15));


        System.out.println(solve(l));
    }

}
