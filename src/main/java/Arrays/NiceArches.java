package Arrays;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class NiceArches {

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
        InputReader in= new NiceArches().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){
        int count=0;
        while(n-->0){
            Stack<Character> s= new Stack<Character>();
            String word=in.next();
            for (char ch : word.toCharArray()){
                if(!s.isEmpty() && s.peek()==ch)
                    s.pop();
                else
                    s.push(ch);
            }
            if(s.isEmpty())
                count++;

        }
        out.println(count);
    }
}
