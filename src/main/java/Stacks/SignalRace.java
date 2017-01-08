package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class SignalRace {

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
        InputReader in= new SignalRace().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int T=in.nextInt();
        solve(in,out,T);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int t){

        while(t-->0) {
            int n=in.nextInt();
            int[] arr = new int[n];
            int[] ans = new int[n];
            int index = 0;
            while (index < n) {
                arr[index++] = in.nextInt();
            }

            Stack<Integer> s = new Stack<Integer>();
            s.push(n-1);
            for(int i=n-2;i>=0;i--){
                if(!s.isEmpty()){
                    int tp=s.peek();
                    while (arr[tp]<arr[i]){
                        ans[tp]=tp-i;
                        s.pop();
                        if(s.isEmpty())
                            break;
                        tp=s.peek();
                    }
                }
                s.push(i);
            }
            while(!s.isEmpty()){
                int tp=s.pop();
                ans[tp]=tp+1;
            }
            for(int i=0;i<n-1;i++){
                out.print(ans[i]+ " ");
            }
            out.println(ans[n-1]);
        }
    }
}
