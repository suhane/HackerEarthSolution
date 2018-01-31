package interviewBits.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by labuser on 8/8/17.
 */
public class LongestSubsequence {

    public  static int lis(final List<Integer> a) {
        int size=a.size();
        int[] count= new int[size];
        count[0]=1;
        int max=1;
        for(int i=1;i<size;i++){
            count[i] = 1;
            for(int j=0;j<=i;j++){
                if(a.get(i)>a.get(j))
                    count[i]=Math.max(count[j]+1,count[i]);
            }

            max=Math.max(max,count[i]);

        }

        return max;

    }

    public static void main(String args[])
    {
        int arr[] = { 69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 };
        int n = arr.length;
        List<Integer> A= new ArrayList<Integer>();
        for(int el: arr){
            A.add(el);
        }
        //Collections.sort(A);
        System.out.println("Length of lis is " + lis(A) );
    }
}
