package TwoPointerAlgorithm;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

/**
 Given an array containing N integers, you need to find the length of the smallest contiguous subarray that contains atleast K distinct elements in it.
 Output "−1" if no such subarray exists.
 * Created by suhane on 10/2/16.
 */
public class MotivationProblem4 {

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
        InputReader in= new MotivationProblem4().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int K=in.nextInt();
        solve(in,out,N,K);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n,int k){

        int[] a=new int[n];
        int i=0;
        while(i<n){
            a[i++]=in.nextInt();
        }
        int res=Integer.MAX_VALUE;
        int l=0,r=0;
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer,Integer> cnt= new HashMap<Integer,Integer>();
        while(l<n){
            while(r<n && set.size()<k){
                set.add(a[r]);
                cnt.put(a[r],cnt.containsKey(a[r])?cnt.get(a[r])+1:1);
                r++;
            }
            if (set.size() >=k) {
                res = Math.min(res, r-l);
            }
            if ( cnt.get(a[l]) == 1 )
                set.remove(a[l]);
            cnt.put(a[l],cnt.get(a[l])-1);
            l++;

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
