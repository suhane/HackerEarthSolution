package interviewBits.Array;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

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
public class MaxNonNegativeSubarray {

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
        InputReader in= new MaxNonNegativeSubarray().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        int[] a=new int[n];
        int i=0;
        ArrayList<Integer> input= new ArrayList<Integer>();
        while(i<n){
            input.add(in.nextInt());
            i++;
        }

        ArrayList<Integer> output= maxset(input);
        System.out.print(output);

    }

    public  static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long res=Integer.MIN_VALUE;
        ArrayList<Integer> output= new ArrayList<Integer>();
        int n=a.size();
        int l=0,r=0;
        long sum=0;
        int start=0;
        int end=0;
        int maxLen=0;
        while(l<n){
            while(r<n && a.get(r)>=0){
                sum+=a.get(r++);
            }
            if(sum>=res){
                int length=r-l;
                if((sum==res && length>maxLen) || sum>res) {
                    start = l;
                    end = r - 1;
                    maxLen=end-start+1;
                    res=sum;
                }

            }
            sum = 0;
            r++;
            l=r;

        }
        while(start<=end){
            output.add(a.get(start++));
        }
        return  output;

    }





}
