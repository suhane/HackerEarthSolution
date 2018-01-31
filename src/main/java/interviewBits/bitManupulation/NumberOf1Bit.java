package interviewBits.bitManupulation;

/**
 * Created by labuser on 7/23/17.
 */
public class NumberOf1Bit {
    public static int numSetBits(long a) {
        int ans = 0;
        while (a > 0) {
            ans += a & 1;
            a >>= 1;
        }
        return ans;

    }

    private static int countBits(long a) {
        int dig=1;
        long n=2;
        int pow=1;
        while(a>n){
            n= (long) Math.pow(2,pow++);
            dig++;
        }
        return dig;
    }

    public static void main(String args[]){
        System.out.print(numSetBits(11));
    }
}
