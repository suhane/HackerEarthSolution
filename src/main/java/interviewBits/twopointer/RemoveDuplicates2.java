package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Created by labuser on 7/27/17.
 */
public class RemoveDuplicates2 {

    public static int removeDuplicates(ArrayList<Integer> a) {
        int n=a.size();
        int r=0;
        int repeatCount=1;
        int i=0;
        for(int j=0;j<n;j++){
            if(j>0 && a.get(j).intValue()==a.get(j-1).intValue()){
                if(repeatCount<2) {
                    repeatCount++;
                    a.set(i, a.get(j));
                    i++;
                }
            }
            else{
                repeatCount=1;
                a.set(i, a.get(j));
                i++;
            }
        }


        while(i<n){
            a.remove(n-1);
            n--;
        }
        return i;

    }

    public static void main(String args[]){

        int[] arr1={ 1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};

        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr1){
            a.add(x);
        }
        System.out.print(removeDuplicates(a));
    }
}
