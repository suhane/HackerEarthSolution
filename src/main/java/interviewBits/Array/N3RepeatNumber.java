package interviewBits.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by labuser on 7/15/17.
 */
public class N3RepeatNumber {
    // DO NOT MODIFY THE LIST
    public static int repeatedNumber(final List<Integer> a) {
        int n=a.size();
        if(n<=2 && n>0)
            return a.get(0);
        int countA=0;
        int countB=0;
        int elemA=0,elemB=0;

        for(int i=0;i<n;i++){
            int elem=a.get(i);
            if(elem!=elemB &&(countA==0 || elem==elemA)){
                countA++;
                elemA=elem;
            }
            else{
                if(countB==0 || elemB==elem){
                    countB++;
                    elemB=elem;
                }
                else{
                     countA--;
                        countB--;
                }
            }
        }
        countA=0;
        countB=0;
        for(int i=0;i<n;i++){
            if(a.get(i)==elemA)
                countA++;
            if(a.get(i)==elemB)
                countB++;
            if(countA>n/3)
                return elemA;
            if(countB>n/3)
                return elemB;
        }




        return -1;
    }

    public static void main(String args[]){
        List<Integer> a=new ArrayList<Integer>();
        int[] num={ 1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 1000669, 1000489, 1000727, 1000329, 1000727, 1000050, 1000209, 1000109 };
       /* a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);
*/

        for(int n:num){
            a.add(n);
        }

        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int n:num){
            if(hm.containsKey(n))
                hm.put(n,hm.get(n)+1);

            else
                hm.put(n,1);
        }
        repeatedNumber(a);
    }
}
