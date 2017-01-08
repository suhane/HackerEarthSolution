package Arrays;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class MonkandRotation {

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
        InputReader in= new MonkandRotation().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int T){

        while(T-->0){
            int n=in.nextInt();
            int k=in.nextInt();
            int[] A= new int[n];
            int i=0;
            while(i<n) {
                A[i++] = in.nextInt();
            }
            k=k%n;
            reverse(A,n-k,n-1);
            reverse(A ,0,n-k-1);
            reverse(A,0,n-1);
            print(A,n,out);
            out.println();
        }


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
