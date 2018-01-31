package interviewBits.binarySearch;

/**
 * Created by labuser on 7/23/17.
 */
public class ImplementPow {

    public static int pow(int x, int n, int d) {

        int pow=n;
        long ans=1;
        long square=Math.abs(x);
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        square=square%d;
        while(n!=0)
        {
            if(n%2!=0)
                ans=ans*square%d;
            square=(square* square)%d;
            n=n/2;
        }
        if(x<0 && pow%2!=0)
            return (int) (d-ans);
        else
            return (int) ans;
    }

    public static int powA(int x, int n, int d) {
        int pow=(int) powUtil(Math.abs(x),n,d);
        if(x<0 && n%2!=0)
            return d-pow;
        return pow;
    }

    private static long powUtil(int x, int n, int d) {
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return x%d;
        long pow=powUtil(x,n/2,d);
        long square=(pow*pow)%d;
        if(n%2==0)
            return square ;
        else
            return (square*x)%d;
    }



    public static void main(String s[]){
        System.out.println(powA(71045970,41535484,64735492));
    }
}
