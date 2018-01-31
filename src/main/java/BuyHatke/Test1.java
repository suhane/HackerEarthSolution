package BuyHatke;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

    public static void main(String args[] ) throws Exception {


        //Scanner
        Scanner s = new Scanner(System.in);
        PrintWriter out= new PrintWriter(System.out);
        int n = s.nextInt();
        int w=s.nextInt();
        solve(s,out,n,w);
        out.close();
        System.exit(0);

    }

    private static void solve(Scanner s, PrintWriter out, int n, int w) {

        int[] arr=new int[n];
        int i;
        for(i=0;i<n;i++){
            arr[i]=w-s.nextInt();
        }
        i=0;
        Arrays.sort(arr);
        int sumLeft=w;
        int max=0;
        while (sumLeft>0 && i<n){
            if(sumLeft>arr[i]){
                max++;
            }
            sumLeft-=arr[i++];
        }
        out.println(max);


    }

}
