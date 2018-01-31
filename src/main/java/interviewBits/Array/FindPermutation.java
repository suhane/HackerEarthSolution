package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by labuser on 7/13/17.
 */
public class FindPermutation {
    public static ArrayList<Integer> findPerm(final String A, int B) {
        int smallest=1;
        int largest=B;
        ArrayList<Integer> out= new ArrayList<Integer>();

        for(char c: A.toCharArray()){
            if(c=='D'){
                out.add(largest--);
            }
            else{
                out.add(smallest++);
            }

        }
        out.add(smallest);
        return out;


    }

    public static int[] findPerm2(final String S, int B){
        int[] ans=new int[B];
        int start = 1, upto = B;
        char[] A=S.toCharArray();
        for(int i = 0; i < B && (start < upto); i++) {
            if(A[i] == 'D') ans[i] = upto--;
            else ans[i] = start++;
        }
        ans[B - 1] = start;
        return ans;
    }

    public static void main(String args[]){

        findPerm2("ID",3);
    }
}
