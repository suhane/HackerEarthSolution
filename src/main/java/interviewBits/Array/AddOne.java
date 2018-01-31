package interviewBits.Array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by suhane on 6/17/17.
 */
public class AddOne {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        int size=a.size();
        int carry=1;
        for(int i=size-1;i>=0;i--){
            int num=a.get(i);
            num+=carry;
            if(num>=10){
                carry=1;
                num%=10;
            }
            else
                carry=0;
            a.set(i,num);
            if(carry==0)
                break;
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(carry!=0)
            res.add(carry);
        int i=0;
        while(a.get(i)==0 && carry==0){i++;}

        while(i<size){
            res.add(a.get(i++));
        }

        return res;

    }
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(9);
        a.add(9);
        a.add(9);a.add(9);a.add(9);
        plusOne(a);
    }

}
