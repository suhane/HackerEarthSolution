package interviewBits.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by suhane on 7/2/17.
 */
public class WaveArray {
    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        ArrayList<Integer> out=new ArrayList<Integer>();
        Collections.sort(a);
        int n=a.size();
        if(n<=1)
            return a;
        for(int i=1;i<n;i+=2){
            out.add(a.get(i));
            out.add(a.get(i-1));
        }
        if(n%2!=0)
            out.add(a.get(n-1));
        return out;

    }

    public static void main(String args[]){
        ArrayList<Integer> in= new ArrayList<Integer>();
        in.add(8);in.add(89);in.add(34); in.add(5); in.add(9);
        wave(in);

    }
}
