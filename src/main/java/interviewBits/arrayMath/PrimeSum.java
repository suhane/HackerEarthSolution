package interviewBits.arrayMath;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by labuser on 7/15/17.
 */
public class PrimeSum {
    public static ArrayList<Integer> primesum(int a) {
        boolean prime[] = new boolean[a+1];
        ArrayList<Integer> output= new ArrayList<Integer>();
        for(int i=0;i<a;i++)
            prime[i] = true;

        for(int p = 2; p*p <=a; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= a; i += p)
                    prime[i] = false;
            }
        }


        for(int i = a/2; i >= 2; i--)
        {
            if(prime[i] == true && prime[a-i]==true){
                output.add(i);
                output.add(a-i);
                return output;
            }

        }
        return null;
    }

    public static void main(String args[]){
        primesum(24);
    }


}
