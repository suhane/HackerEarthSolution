package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class MonkAndPhilosophersStone {

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
        InputReader in= new MonkAndPhilosophersStone().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        int[] arr=new int[n];
        int index=0;
        while(index<n){
            arr[index++]=in.nextInt();
        }

        int q=in.nextInt();
        int x=in.nextInt();

        Stack<Integer> s=new Stack<Integer>();
        int i=0;
        int count=0;
        while(q-->0){
            String choice=in.next();
            if(choice.equals("Harry")){
                s.push(arr[i]);
                count+=arr[i++];
                if(count==x) {
                    out.println(s.size());
                    return;
                }
            }
            else {
                count-=s.pop();
                if(count==x) {
                    out.println(s.size());
                    return;
                }
            }
        }
        out.println(-1);
    }
}
