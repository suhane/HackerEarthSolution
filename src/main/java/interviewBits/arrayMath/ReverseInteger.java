package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class ReverseInteger {

    public static int reverse(int a) {
        int n=Math.abs(a);
    int dig=0;
    long rev=0;
    while(n!=0){
        int mod=n%10;
        rev*=10;
        if(rev>Integer.MAX_VALUE)
            return 0;
        rev+=mod;
        n=n/10;
    }

    if(a<10)
            return (int) -rev;
    return (int) rev;


}
    public static void main(String s[]){
        reverse(-1146467285);
    }
}
