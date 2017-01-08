package Arrays;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class Speed7 {

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
        InputReader in= new Speed7().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int T){
        Stack<Integer> s= new Stack<Integer>();
        while(T-->0){
            int N=in.nextInt();
            int[] cars= new int[N];
            int index=0;
            while(index<N){
                cars[index++]=in.nextInt();
            }
            int count=1;
            for(int i=1;i<N;i++){
                if(cars[i]<cars[i-1])
                    count++;
                else{
                    cars[i]=cars[i-1];
                }
            }
            out.println(count);
        }
    }
}
