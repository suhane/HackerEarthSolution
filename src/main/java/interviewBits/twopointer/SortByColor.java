package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/26/17.
 */
public class SortByColor {

    public static void sortColors(ArrayList<Integer> a) {
        int redpointer=0;
        int whitepointer=0;
        int bluepointer=0;
        int n=a.size();
        for(int i=0;i<n;i++){
                if(a.get(i)==0)
                    redpointer++;
            else
                    if(a.get(i)==1)
                        whitepointer++;
            else
                        bluepointer++;
        }
        int i=0;
        while(i<redpointer){
            a.set(i++,0);
        }
        int j=0;
        while(j++<whitepointer){
            a.set(i++,1);
        }
        j=0;
        while(j++<bluepointer){
            a.set(i++,2);
        }

        System.out.print(a);
    }

    public static void sortColors2(ArrayList<Integer> a) {
        int n=a.size();
        int red=0;
        int blue=n-1;
        for(int i=0;i<=blue;i++){
            if(a.get(i)==0){
                int temp=a.get(red);
                a.set(red,0);
                a.set(i,temp);
                red++;
            }
            else if(a.get(i)==2){
                int temp=a.get(blue);
                a.set(blue,2);
                a.set(i,temp);
                blue--;
                i--;
            }
        }
        System.out.print(a);


    }

    public static void main(String args[]){

        int[] arr={0 ,1, 2, 0 ,1, 2};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        sortColors2(a);
    }
}
