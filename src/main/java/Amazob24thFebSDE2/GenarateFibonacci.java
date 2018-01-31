package Amazob24thFebSDE2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class GenarateFibonacci {

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
        InputReader in= new GenarateFibonacci().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int n=in.nextInt();
        if(n>0)
            solve(in,out,n);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){
        int a=0;
        int b=1;
        System.out.println(a);
        n--;
        if(n>0) {
            System.out.println(b);
            n--;
        }
        while(n-->0){
            int c=a+b;
            System.out.println(c);
            a=b;
            b=c;
        }

    }


}
