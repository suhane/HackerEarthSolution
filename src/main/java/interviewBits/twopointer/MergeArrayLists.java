package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Input :
 A : [6 9]              1 9
 B : [1 5 8]            6 5 8


 Modified A : [1 5 6 8 9]
 *
 * Created by labuser on 7/26/17.
 */
public class MergeArrayLists {

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n=a.size();
        int m=b.size();

        int mergepointer=0;
        int targetpointer=0;
        ArrayList<Integer> output=new ArrayList<Integer>();

        while(targetpointer<m && mergepointer<n){
            if(a.get(mergepointer)<=b.get(targetpointer)){
                output.add(a.get(mergepointer));
                mergepointer++;
            }
            else if(b.get(targetpointer)<=a.get(mergepointer)){
                output.add(b.get(targetpointer));
                targetpointer++;
            }

        }

        while(targetpointer<m)
            output.add(b.get(targetpointer++));
        while(mergepointer<n)
            output.add(a.get(mergepointer++));

        int i=0;
        a.clear();
        for(int el: output){
            a.add(el);
        }
        return a;
    }

    public static void main(String args[]){

        int[] arr1={-5};

        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr1){
            a.add(x);
        }

        int[] arr2={-5 };

        ArrayList<Integer> b=new ArrayList<Integer>();

        for(int x:arr2){
            b.add(x);
        }
        System.out.print(merge(a,b));
    }
}
