package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/12/17.
 */
public class NextPermutation {

    public static void nextPermutation(ArrayList<Integer> a) {

        int n=a.size();
        if(n<=1)
            return;
        int i;
        for(i=n-2;i>=0;i--){
            if(a.get(i)<a.get(i+1)){
                break;
            }
        }
        if(i==-1){
            reverse(a,0,n-1);
            return;
        }


        int startSuffixIndex=i+1;
        int endSuffixIndex=n-1;
        int lastElemIndex=i;
        int startSwapIndex=n-1;
        while(a.get(lastElemIndex)>a.get(endSuffixIndex)){
            endSuffixIndex--;
        }
        int temp=a.get(lastElemIndex);
        a.set(lastElemIndex,a.get(endSuffixIndex));
        a.set(endSuffixIndex,temp);
        reverse(a,startSuffixIndex,n-1);


    }

    private static void reverse(ArrayList<Integer> a, int start, int end) {
        while(start<end){
            int temp=a.get(start);
            a.set(start,a.get(end));
            a.set(end,temp);
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        ArrayList<Integer> in= new ArrayList<Integer>();
        in.add(3);in.add(2);in.add(1); //in.add(6);in.add(5);in.add(4);
        nextPermutation(in);
    }
}
