package TwoPointerAlgorithm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Given a sorted array A, having N integers. You need to find any pair(i,j) having sum as given number X
 * Created by suhane on 10/2/16.
 */
public class MotivationProblem1 {

    class InputReader{
        BufferedReader br;
        StringTokenizer token;

        public InputReader(InputStream stream){
            br=new BufferedReader(new InputStreamReader(stream));
            token=null;
        }

        public String next(){
            while(token==null || !token.hasMoreTokens()){
                try{
                    token= new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public int nextInt(){
            return  Integer.parseInt(next());
        }
    }

    public static void main(String args[]){
        InputReader in= new MotivationProblem1().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int sum=in.nextInt();
        solve(in,out,N,sum);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n,int sum){

        int[] a=new int[n];
        int l=0,r=n-1;
        int i=0;
        while(i<n){
            a[i++]=in.nextInt();
        }
        while(l<r){
            if(a[l]+a[r]==sum){
                out.println("The pairs are "+l+" and "+r);
                return;
            }
            else if(a[l]+a[r]>sum)
                r--;
            else if(a[l]+a[r]<sum)
                l++;

        }
        out.println("Could not find any such pair");
    }




    private static void print(int[] a, int n, PrintWriter out) {
        int i=0;
        while(i<n){
            out.print(a[i++] + " ");
        }
    }

    private static void reverse(int[] a,int i, int k) {
    while(i<k){
        int temp=a[i];
        a[i]=a[k];
        a[k]=temp;
        i++;
        k--;
    }
    }
}
