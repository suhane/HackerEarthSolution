package interviewBits.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhane on 6/17/17.
 */
public class MissingNumber {

    public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {


            int l = a.size();
            long actualsum = 0;
            long actualsumSqares = 0;
            for (int el : a) {
                actualsum += 1L*el;
                actualsumSqares += 1L* el * el;
            }
            long expectedsum = 1L*l * (1L*l + 1) / 2;
            long expectedsumsqaures = expectedsum * (2 * 1L*l + 1) / 3;

            long A = (((actualsumSqares - expectedsumsqaures) / (actualsum - expectedsum)) + (actualsum - expectedsum)) / 2;
            long B = A - (actualsum - expectedsum);

            ArrayList<Integer> out = new ArrayList<Integer>();
            out.add((int) A);
            out.add((int) B);
            return out;

    }
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(3);
        a.add(1);
        a.add(2);a.add(5);a.add(3);
        repeatedNumber(a);
    }

}
