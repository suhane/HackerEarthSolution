package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Created by labuser on 7/25/17.
 */
public class DiffK {

    public static int diffPossible(ArrayList<Integer> a, int b) {

        int n=a.size();
        int l=0;
        int r=1;
        while(r<n) {
            int x = a.get(r);
            int y = a.get(l);
            if (x - y == b) {
                return 1;
            } else {
                //shrint the difference
                while (l < r-1 && a.get(r).intValue() - a.get(l).intValue() > b) {
                    l++;
                    if (a.get(r).intValue() - a.get(l).intValue() == b)
                        return 1;
                }
                r++;
            }
        }
        return 0;
    }

    public static int diffPossible2(ArrayList<Integer> a, int b) {

        int n=a.size();
        int l=0;
        int r=1;
        while(r<n && l<=r) {
            int x = a.get(r);
            int y = a.get(l);
            if (x - y == b && r!=l) {
                return 1;
            } else {
                if(x-y>b)
                    l++;
                else
                    r++;
            }
        }
        return 0;
    }

    public static void main(String args[]){
        int[] arr={1, 2, 2, 3, 4 };
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.println(diffPossible2(a,2));
    }
}
