package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Created by labuser on 7/25/17.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(ArrayList<Integer> a) {
        int n=a.size();
        int currSize=n;
        int j=1;
        for(int i=0;i<currSize-1;i++){

            if(a.get(i).intValue()!=a.get(i+1).intValue()){
                a.set(j,a.get(i+1));
                j++;
            }


        }
        return j;

    }

    public static void main(String args[]){

        int[] arr1={ 0, 0, 0, 1, 1, 2, 2, 3};

        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr1){
            a.add(x);
        }
        System.out.print(removeDuplicates(a));
    }
}
