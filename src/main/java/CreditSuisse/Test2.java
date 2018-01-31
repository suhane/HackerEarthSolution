package CreditSuisse;

import java.io.PrintWriter;
import java.util.Scanner;

public class Test2 {

    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        PrintWriter out= new PrintWriter(System.out);
        int n = s.nextInt();
        int q= s.nextInt();
        solve(s,out,n,q);
        out.close();
        System.exit(0);

    }

    private static void solve(Scanner s, PrintWriter out, int n, int q) {

        int[] arr=new int[n];
        int maxIndex=1;
        int minIndex=n;
        while(q-->0){
            int type=s.nextInt();
            int k=s.nextInt();

            switch (type){
                case 1:{
                    arr[k-1]=-1;
                    maxIndex=Math.max(k,maxIndex);
                    minIndex=Math.min(k,minIndex);
                    break;
                }
                case 2: {
                    if (k > maxIndex) {
                        out.println(-1);
                        break;
                    }
                    if(k<=minIndex){
                        out.println(minIndex);
                        break;
                    }
                    for (int i = k-1; i <= maxIndex; i++) {
                        if (arr[i] == -1) {
                            out.println(i + 1);
                            break;
                        }
                    }
                }
            }


        }


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
