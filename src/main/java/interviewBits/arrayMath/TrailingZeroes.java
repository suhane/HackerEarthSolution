package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class TrailingZeroes {

    public static  int trailingZeroes(int a) {
    int sum=0;
        while(a!=0){
            a=a/5;
            sum+=a;
        }
    return sum;
    }
}
