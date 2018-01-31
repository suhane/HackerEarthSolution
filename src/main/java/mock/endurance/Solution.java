package mock.endurance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;


public class Solution {

    class InputReader{
        BufferedReader reader;
        StringTokenizer token;

        public InputReader(InputStream stream) {
            reader= new BufferedReader(new InputStreamReader(stream));
            token=null;

        }
        public String next(){
            while(token==null || !token.hasMoreTokens()){
                try {
                    token =new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }


    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        InputStream is=System.in;
        OutputStream os=System.out;
        InputReader in=new Solution().new InputReader(is);
        PrintWriter out=new PrintWriter(os);
        int n=in.nextInt();
        solve(n,in,out);
        out.close();
        System.exit(0);
    }

    static class Number{
        int x;
        Number(int x){
            this.x=x;
        }
    }

    private static void solve(int n, InputReader in, PrintWriter out){

        Stack<Integer> s= new Stack<Integer>();
        Stack<Integer> q= new Stack<Integer>();
        while(n-->0){
            String op=in.next();
            if(op.equals("push")){
                    int input=in.nextInt();
                    s.push(input);
                    out.println(s.peek());
            }
            else if(op.equals("pop")){
                if(!s.isEmpty()) {
                    s.pop();
                }
                if(s.isEmpty())
                    out.println("EMPTY");
                else
                    out.println(s.peek());
            }
            else{
                int x=in.nextInt();
                int d=in.nextInt();
                int stackSize=s.size();
                int elmToPush=stackSize-x;
                while(elmToPush-->0){
                    q.push(s.pop());
                }
                while(!s.isEmpty()){
                    q.push(s.pop()+d);
                }
                while(!q.isEmpty()){
                    s.push(q.pop());
                }
                out.println(s.peek());
            }

        }


    }

}