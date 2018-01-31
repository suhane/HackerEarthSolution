package Capillary;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class StringQueries {

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
        InputReader in= new StringQueries().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        int Q=in.nextInt();
        solve(in,out,N,Q);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n, int q) {

        String str=in.next();
        char[] strarray=str.toCharArray();
        while(q-->0){
            int l=in.nextInt();
            int r=in.nextInt();



        }
    }

}

