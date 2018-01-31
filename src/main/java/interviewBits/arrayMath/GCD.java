package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class GCD {

    public static int gcd(int a, int b) {

        if(a==0)
            return b;
        if(b==0)
            return a;
    int limit;
        if(a>b)
            limit=b;
        else
            limit=a;
        int gcd=1;
        for(int i=2;i<=limit;i++){
            if((a%i==0)&&(b%i==0)){
                gcd=i;
            }

        }
        return gcd;
    }

    public int recursivegcd(int A, int B) {
        if (A == 0)
            return B;
        return recursivegcd(B % A, A);
    }

    public static void main(String s[]){
        gcd(6,9);
    }
}
