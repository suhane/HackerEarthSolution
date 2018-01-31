package Arrays;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class MarkTheAnswer {

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
        InputReader in= new MarkTheAnswer().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int X= in.nextInt();
        solve(in,out,N,X);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n,int x){
        int count=0;
        int n_att=0;
        while(n-->0) {
            int q = in.nextInt();
            if (q > x && count > 0) {
                out.println(n_att);
                break;
            } else {
                if ((q > x && count == 0) || q <= x){
                    n_att=(q<=x)?n_att+1:n_att;
                    count=q>x?count+1:count;
                }

            }
        }
        out.println(n_att);
    }
}
