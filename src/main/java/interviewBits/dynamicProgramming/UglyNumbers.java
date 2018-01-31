package interviewBits.dynamicProgramming;

import java.util.HashMap;

/**
 *
 *
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.

 Given a number n, the task is to find n’th Ugly number.

 Input  : n = 7
 Output : 8

 Input  : n = 10
 Output : 12

 Input  : n = 15
 Output : 24

 Input  : n = 150
 Output : 5832
 * Created by labuser on 8/9/17.
 */

public class UglyNumbers {

    private static HashMap<Integer,Boolean> memoized;

    public static void generateUglyNumbers(int n){
        memoized= new HashMap<Integer, Boolean>();
        //System.out.print(1);
        memoized.put(1,true);
        int count=1;
        int num=1;
        while(count<n){
            num=num+1;
            int i=num;
            if(i%2==0){
                i=i/2;
                if(memoized.containsKey(i)) {
                    //System.out.print(" " + num);
                    memoized.put(num,true);
                    count++;
                }
            }
            else
                if(i%3==0){
                    i=i/3;
                    if(memoized.containsKey(i)) {
                        //System.out.print(" " + num);
                        memoized.put(num,true);
                        count++;
                    }
                }
            else if(i%5==0){
                    i=i/5;
                    if(memoized.containsKey(i)) {
                        //System.out.print(" " + num);
                        memoized.put(num,true);
                        count++;
                    }
                }
        }

        System.out.print(num);

    }

    public static void main(String args[]){


        generateUglyNumbers(150);
    }


}
