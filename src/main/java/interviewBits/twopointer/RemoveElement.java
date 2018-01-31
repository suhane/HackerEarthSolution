package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by labuser on 7/26/17.
 */
public class RemoveElement {

    public static int removeElement(ArrayList<Integer> a, int b) {
        int n=a.size();
        int i=0;
        for(int j=0;j<n;j++){

            if(a.get(j)!=b){
                a.set(i,a.get(j));
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

        int[] arr={4, 1, 1, 2, 1, 3};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        removeElement(a,1);
    }
}
