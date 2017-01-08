package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class BalancedParentheses {

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

        public long nextLong(){
            return  Long.parseLong(next());
        }

        public int nextInt(){
            return  Integer.parseInt(next());
        }


    }

    public static void main(String args[]){
        InputReader in= new BalancedParentheses().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        int[] arr=new int[n];
        int index=1;
        int maxlength=0;
        int length=0;
        Stack<Integer> s=new Stack<Integer>();
        s.push(0);
        while(index<=n) {
            int item=in.nextInt();
            arr[index-1]=item;
            if(item>0)
                s.push(index);
            else{
                int curr=s.pop();
                if(arr[curr-1==-1?0:curr-1]==-item){
                    if(!s.empty()){
                        maxlength=Math.max(maxlength,index-s.peek());
                    }
                    else
                        s.push(index);
                }
                else
                    s.push(index);
            }
            index++;
        }
        out.print(maxlength);

    }
}
