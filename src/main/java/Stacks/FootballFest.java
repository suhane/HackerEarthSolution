package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class FootballFest {

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
        InputReader in= new FootballFest().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int T=in.nextInt();
        solve(in,out,T);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int T){

        while(T-->0){
            Stack<Integer> stack= new Stack<Integer>();
            int N=in.nextInt();
            int ID=in.nextInt();
            int p=0;
            stack.push(ID);
            while(N-->0){
                String passType=in.next();
                if(passType.equals("P")) {
                    stack.push(in.nextInt());
                }
                else{
                    int first=stack.pop();
                    int second=stack.pop();
                    stack.push(first);
                    stack.push(second);
                }
            }
            out.println("Player "+stack.peek());
        }




    }
}
