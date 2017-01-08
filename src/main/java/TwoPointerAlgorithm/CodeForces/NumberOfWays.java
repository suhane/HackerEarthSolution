package TwoPointerAlgorithm.CodeForces;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 Given an array containing N integers, you need to find the length of the smallest contiguous subarray that contains atleast K distinct elements in it.
 Output "−1" if no such subarray exists.
 * Created by suhane on 10/2/16.
 */
public class NumberOfWays {

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
        InputReader in= new NumberOfWays().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        int[] a=new int[n];
        int[] cnt=new int[n];
        int index=0;
        int sum=0;
        while(index<n){
            a[index]=in.nextInt();
            sum+=a[index++];
        }
        if(sum%3!=0) {
            out.println(0);
            return;
        }
        else {
            sum /= 3;
            long ss = 0;
            for(int i = n-1; i >= 0 ; --i)
            {
                ss += a[i];
                if (ss == sum)
                    cnt[i] = 1;
            }
            for(int i = n-2 ; i >= 0 ; --i)
                cnt[i] += cnt[i+1];

            long ans = 0;
            ss = 0;
            for(int i = 0 ; i+2 < n ; ++i) {
                ss += a[i];
                if (ss == sum)
                    ans += cnt[i+2];
            }
            out.println(ans);

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
