package TwoPointerAlgorithm;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  Given an array having NN integers,, find the contiguous subarray having sum as great as possible,, but not greater than M
 input
 5 12
 2 1 3 4 5
 output
 12

 input
 4 9
 7 3 5 6
 output
 8
 * Created by suhane on 10/2/16.
 */
public class MotivationProblem3 {

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
        InputReader in= new MotivationProblem3().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int M=in.nextInt();
        solve(in,out,N,M);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n,int m){

        int[] a=new int[n];
        int i=0;
        while(i<n){
            a[i++]=in.nextInt();
        }
        int res=Integer.MIN_VALUE;
        int l=0,r=0,sum=0;
        while(l<n){
            while(r<n && sum+a[r]<=m){
                sum+=a[r++];
            }
            res=Math.max(res,sum);
            sum-=a[l++];

        }
        out.println(res);
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
