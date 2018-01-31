package interviewBits.bitManupulation;

/**
 * Created by labuser on 7/23/17.
 */
public class ReverseBits {
    public static long reverse(long a) {
        long i=0;
        long temp=0;
        long maxBits=32;
        long SET=1;
        while(i<maxBits){
            long lastbit=a & 1;
            if(lastbit==1)
                temp=temp | (SET<<(maxBits-1-i));
            a>>=1;
            i++;
        }
        return temp;
    }

    public static void main(String args[]){
        long a=1;
        long b=31;
        long c=a<<b;
       //System.out.print(c);
        System.out.print(reverse(3));
    }

}
