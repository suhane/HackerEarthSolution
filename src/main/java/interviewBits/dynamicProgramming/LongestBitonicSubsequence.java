package interviewBits.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhane1 on 8/9/17.
 */
public class LongestBitonicSubsequence {

    public static int longestSubsequenceLength(final List<Integer> A) {
        int n=A.size();
        int[] lis= new int[n];
        int[] lds= new int[n];
        for(int i=0;i<n;i++){
            lis[i]=1;
            lds[i]=1;
        }

        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if(A.get(i)> A.get(j) && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
        }

        for (int i=n-2;i>=0;i--){
            for (int j=n-1;j>=i;j--){
                if(A.get(i) > A.get(j) && lds[i]<lds[j]+1){
                    lds[i]=lds[j]+1;
                }
            }
        }

        int longest=-1;
        for(int i=0;i<n;i++){
            longest=Math.max(lis[i]+lds[i],longest);
        }
        return longest-1;
    }

    public static void main(String args[])
    {
        int arr[] = { 1 ,11, 2, 10, 4, 5, 2, 1, 12, 1, 5, 6, 8, 15, 17, 11, 9, 4, 2 };
        int n = arr.length;
        List<Integer> A= new ArrayList<Integer>();
        for(int el: arr){
            A.add(el);
        }
        System.out.println("Length of lis is " + longestSubsequenceLength(A) );
    }


}

