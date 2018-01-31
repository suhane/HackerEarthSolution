package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by labuser on 7/25/17.
 */
public class ThreeSumZero {
    public  static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
            ArrayList<ArrayList<Integer>> output= new ArrayList<ArrayList<Integer>>();
            Collections.sort(a);
            int n=a.size();
            for(int i=0;i<n;i++){
                if(i>0 && a.get(i-1).intValue()==a.get(i).intValue())
                    continue;
                int target=a.get(i);
                int l=i+1;
                int r=n-1;
                while(l<r){
                    long sum=a.get(l).longValue()+a.get(r).longValue();
                    if(sum==-target){
                        ArrayList<Integer> temp= new ArrayList<Integer>();
                        temp.add(target);
                        temp.add(a.get(l));
                        temp.add(a.get(r));
                        output.add(temp);
                        while(l<r && a.get(l).intValue()==a.get(l+1).intValue())
                            l++;
                        l++;
                        while(l<r && a.get(r).intValue()==a.get(r-1).intValue())
                            r--;
                        r--;
                    }
                    else if(sum<-target)
                            l++;
                    else
                        r--;
                }
            }
            return output;
    }


    public static void removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        int currSize = n;
        for (int i = 0; i < currSize - 1; i++) {

            int val1 = a.get(i);
            int val2 = a.get(i + 1);
            if (val1 != val2)
                continue;
            else {
                a.remove(i--);
                currSize--;
            }


        }
    }

        public static void main(String args[]){
            int[] arr={-31013930, -31013930, 9784175, 21229755};
            ArrayList<Integer> a=new ArrayList<Integer>();

            for(int x:arr){
                a.add(x);
            }
            System.out.println(threeSum(a));
        }


}
