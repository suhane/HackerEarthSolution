package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class MankAndPrisonerOfAzkaban {

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
        InputReader in= new MankAndPrisonerOfAzkaban().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        long[] arr=new long[n];
        long[] ans=new long[n];
        long[] rev_ans=new long[n];
        int index=0;
        while(index<n){
            arr[index++]=in.nextLong();
        }

        Stack<Integer> s1=new Stack<Integer>();
        s1.push(0);
        for(int i=1;i<n;i++){
            if(!s1.isEmpty()){
               int tp=s1.peek();
                while(arr[tp]<arr[i]){
                    s1.pop();
                    ans[tp]=i+1;
                    if(s1.isEmpty())
                        break;
                    tp=s1.peek();
                }
            }
            s1.push(i);
        }
        while(!s1.isEmpty()){
            ans[s1.pop()]=-1;
        }

        Stack<Integer> s2=new Stack<Integer>();
        s2.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(!s2.isEmpty()){
                int tp=s2.peek();
                while(arr[tp]<arr[i]){
                    s2.pop();
                    rev_ans[tp]=i+1;
                    if(s2.isEmpty())
                        break;
                    tp=s2.peek();
                }
            }
            s2.push(i);
        }
        while(!s2.isEmpty()){
            rev_ans[s2.pop()]=-1;
        }

        for(int i=0;i<n;i++){
           out.print(ans[i]+rev_ans[i]+ " ");
        }
    }
}
