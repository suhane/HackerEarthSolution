package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class LargestCoPrime {
    public static int cpFact(int A, int B) {
        int x=gcd(A,B);
        while(x!=1){
            A=A/x;
            x=gcd(A,B);
        }
        return A;
    }

    private static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
}
