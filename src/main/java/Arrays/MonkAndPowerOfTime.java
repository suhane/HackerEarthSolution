package Arrays;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/1/16.
 */
public class MonkAndPowerOfTime {
    class InputReader {
        BufferedReader br;
        StringTokenizer token;

        public InputReader(InputStream stream){
            br=new BufferedReader(new InputStreamReader(stream));
            token=null;
        }

        public String next(){
            while(token==null || !token.hasMoreTokens()) {
                try {
                    token = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
        InputReader in= new MonkAndPowerOfTime().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){
        Queue<Integer> calOrder=new LinkedList<Integer>();
        Queue<Integer> idealOrder=new LinkedList<Integer>();
        int i=0;
        while(i++<n){
            calOrder.offer(in.nextInt());
        }
        i=0;
        int op=0;
        while(i++<n){
            idealOrder.offer(in.nextInt());
        }
        while(!calOrder.isEmpty()){
            if(calOrder.peek()!=idealOrder.peek()){
                calOrder.offer(calOrder.poll());
            }
            else{
                calOrder.poll();
                idealOrder.poll();
            }
            op++;
        }
        out.println(op);

    }
}
