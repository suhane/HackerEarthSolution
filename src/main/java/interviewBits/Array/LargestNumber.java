package interviewBits.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by suhane on 7/1/17.
 */
public class LargestNumber {

    static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

    public static String largestNumber(final List<Integer> a) {
        List<Integer>  in= new ArrayList<Integer>();
        for(int num:a){
            hm.put(num,digit(num));
        }
        in.addAll(a);
        sort(in);
        String output="";
        int n=in.size();
        for(int i=n-1;i>=0;i--){
            int num=in.get(i);
            output+=num;
            if(num==0)
                return output;
        }
        return output;
    }

    public static void main(String args[]){
        List<Integer>  in= new ArrayList<Integer>();
        in.add(8);in.add(89);//in.add(34); in.add(5); in.add(9);
        largestNumber(in);

    }

    private static void sort(List<Integer>  A ){
        int len=A.size();
        for(int i=0;i<len-1;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                int x=A.get(j);
                int y=A.get(min);
                if(myCompare(x,y)){
                    min=j;
                }
            }
            int temp=A.get(i);
            A.set(i,A.get(min));
            A.set(min,temp);

        }
    }

    private static boolean myCompare(int x, int y) {
        int digit_x=hm.get(x);
        int digit_y=hm.get(y);
        int m= (int) (x*Math.pow(10,digit_y)+y);
        int n= (int) (y*Math.pow(10,digit_x)+x);
        if(m<n)
            return true;
        else
            return false;
    }

    private static int digit(int y) {
        int digit=0;
        if(y==0)
            return 1;
        while(y!=0){
            digit++;
            y/=10;
        }
        return digit;
    }
}
