package Set40;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class MaxContiguousSum {

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
        InputReader in= new MaxContiguousSum().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){
        int i=0;
        int[] arr=new int[n];
        while(i<n){
            arr[i++]=in.nextInt();
        }
        int max_sum_so_far=arr[0];
        int max_ending_here=arr[0];
        for(i=1;i<n;i++){
            max_ending_here=Math.max(arr[i],max_ending_here+arr[i]);
            if(max_sum_so_far<max_ending_here)
                max_sum_so_far=max_ending_here;
        }
        out.println(max_sum_so_far);
    }
}
