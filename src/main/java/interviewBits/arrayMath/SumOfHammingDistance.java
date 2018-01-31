package interviewBits.arrayMath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/16/17.
 */
public class SumOfHammingDistance {

    public static int hammingDistance(final List<Integer> A) {

        int n=A.size();
        int sum=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<n;j++){
                int elem=A.get(j);
                int bit=1<<i;
                int c = elem & bit;
                if(c!=0)
                    count++;

            }
            sum+=2*(count%1000000007)*((n-count)%1000000007);
        }
        return sum;
    }

    public static void main(String args[]){
        List<Integer> a=new ArrayList<Integer>();
        a.add(2);
        a.add(4);
        a.add(6);//a.add(5);a.add(3);
        hammingDistance(a);
    }
}
