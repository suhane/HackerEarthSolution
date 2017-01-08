package TwoPointerAlgorithm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Given two sorted arrays A and B,each having length N and M respectively.
 * Form a new sorted merged array having values of both the arrays in sorted format.
 * input
 4
 5
 1 3 7 9
 3 6 7 8 10
 * Created by suhane on 10/2/16.
 */
public class MotivationProblem2 {

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
        InputReader in= new MotivationProblem2().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int M=in.nextInt();
        solve(in,out,N,M);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n,int m){

        int[] a=new int[n];
        int[] b=new int[m];
        int[] res=new int[n+m];
        int i=0;
        while(i<n){
            a[i++]=in.nextInt();
        }
        i=0;
        while(i<m){
            b[i++]=in.nextInt();
        }
        int index_a=0,index_b=0,curr_index=0;
        while(index_a<n || index_b<m){
            if(index_a<n && index_b<m){
                if(a[index_a]<=b[index_b]){
                    res[curr_index++]=a[index_a];
                    index_a++;
                }
                else if(a[index_a]>b[index_b]){
                    res[curr_index++]=b[index_b];
                    index_b++;
                }
            }
            else if(index_a<n){
                res[curr_index++]=a[index_a++];
            }
            else if(index_b<m){
                res[curr_index++]=b[index_b++];
            }
        }

        i=0;
        while(i<n+m){
            out.print(res[i++]+" ");
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
