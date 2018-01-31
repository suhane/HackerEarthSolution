package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/2/17.
 */
public class MaximumUnSortedArray {
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> out =new ArrayList<Integer>();
        int n=A.size();
        int l=0;int r=n-1;
        int i,j;
        for(i=0;i<n-1;i++){
            if(A.get(i)>A.get(i+1)){
                break;
            }
        }
        for(j=n-1;j>0;j--){
            if(A.get(j)<A.get(j-1)){
                break;
            }
        }

        if(i==n-1){
            out.add(-1);
            return out;
        }

        int min=A.get(i);
        int max=A.get(j);
        for(int k=i;k<=j;k++){
            min=Math.min(A.get(k),min);
            max=Math.max(A.get(k),max);
        }

        while(l<=i && A.get(l)<=min)
            l++;
        while(r>=j && A.get(r)>=max)
            r--;

        out.add(l);
        out.add(r);


return out;
    }

    public static void main(String args[]){
        ArrayList<Integer> in= new ArrayList<Integer>();
        int[] array={ 4,4, 15,2, 4, 4, 15, 18, 20 };
        for(int x:array){
            in.add(x);
        }
        //in.add(1);//in.add(2);//in.add(2); in.add(4); in.add(5);
        subUnsort(in);

    }
}
