package BuyHatke;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {

    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        PrintWriter out= new PrintWriter(System.out);
        int t = s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int q=s.nextInt();
            solve(s,out,n,q);
        }
        out.close();
        System.exit(0);

    }

    private static void solve(Scanner s, PrintWriter out, int n, int q) {

        int[] arr=new int[n];
        int[] left=new int[n];
        int[] right=new int[n];

        int i;
        for(i=0;i<n;i++){
            arr[i]=s.nextInt();
        }

        int j= s.nextInt();
        left[0]=arr[0];
        int maxLeft=arr[0];
        for(i=1;i<n;i++){
            if(arr[i]>=arr[i-1])
                left[i]=Math.max(maxLeft,arr[i-1]);
            else {
                if (left[i-1]>arr[i])
                    left[i]=0;
                else
                    left[i]=left[i-1];
            }
            maxLeft=Math.max(maxLeft,arr[i]);
        }
        left[0]=0;
        int maxRight=arr[n-1];
        right[n-1]=arr[n-1];
        for(i=n-2;i>=0;i--){
            if(arr[i]>=arr[i+1])
                right[i]=Math.max(maxRight,arr[i+1]);
            else {
                if (right[i+1]>arr[i])
                    right[i]=0;
                else
                    right[i]=right[i+1];
            }
            maxRight=Math.max(maxRight,arr[i]);
        }

        while (q-->0){


            out.println(left[j-1]*arr[j-1]*right[j-1]);
        }





    }

}
