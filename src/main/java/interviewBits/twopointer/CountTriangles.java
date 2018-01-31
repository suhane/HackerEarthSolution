package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Created by labuser on 7/25/17.
 */
public class CountTriangles {

    public static int  nTriang(ArrayList<Integer> A) {

        Collections.sort(A);
        ArrayList<ArrayList<Integer>> output= new ArrayList<ArrayList<Integer>>();
        int n=A.size();
        long count=0;
        for(int i=0;i<n-2;i++){
            int k=i+2;
            for(int j=i+1;j<n;j++){

                while(k<n && A.get(i).intValue()+A.get(j).intValue()>A.get(k).intValue()) {
                    k++;
                }
            count=count+k-j-1;
            }

        }
        count=count%1000000007;
        return (int) count;

    }

    public static int nTriang2(ArrayList<Integer> A) {
        if(A==null)return 0;
        int S[]=new int [A.size()];
        for(int i =0;i<A.size();i++)
            S[i]=A.get(i);
        Arrays.sort(S);
        long count = 0;
        for (int i = 2; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // The edge from S[left] to S[right - 1] will also form a triangle
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }
        count%=1000000007;
        return (int)count;
    }

    public static void main(String args[]){
        int[] arr={1, 1, 1};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.println(nTriang(a));
    }
}
