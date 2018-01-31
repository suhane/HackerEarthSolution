package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.*;

/**
 * Created by suhane on 10/2/16.
 */
public class MonksLoveForFood {

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
        InputReader in= new MonksLoveForFood().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){
        Stack<Integer> s= new Stack<Integer>();
        while(n-->0){
            int q=in.nextInt();
            if(q==1){
                if(!s.isEmpty())
                    out.println(s.pop());
                else
                    out.println("No Food");
            }
            else{
                s.push(in.nextInt());
            }
        }
    }
}
