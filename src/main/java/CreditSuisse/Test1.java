package CreditSuisse;

import java.io.PrintWriter;
import java.util.Scanner;

public class Test1 {

    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        PrintWriter out= new PrintWriter(System.out);
        int t = s.nextInt();
        while (t-->0){
            solve(s,out);
        }
        out.close();
        System.exit(0);

    }

    private static void solve(Scanner s, PrintWriter out) {

        int n=s.nextInt();
        int ans= pow(2,n,1000000007)-2;
        out.println(ans);


    }

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
}
