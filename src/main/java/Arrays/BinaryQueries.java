package Arrays;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * Created by suhane on 9/30/16.
 */
public class BinaryQueries {

    class InputReader{
        BufferedReader reader;
        StringTokenizer token;

        public InputReader(InputStream stream){
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

    public static void main(String args[]){
        InputReader in = new BinaryQueries().new InputReader(System.in);
        PrintWriter out= new PrintWriter(System.out);
        int  N=in.nextInt();
        int Q= in.nextInt();
        solve(N,Q,in,out);
        out.close();
        System.exit(0);
    }

    private static void solve(int n, int q, InputReader in, PrintWriter out) {
        int[] array= new int[n];
        int i=0;
        while(n-->0){
            array[i++]= in.nextInt();
        }
        while(q-->0){
            int firstdigit= in.nextInt();
            switch (firstdigit){
                case 0:{
                    int st_index= in.nextInt();
                    int end_index= in.nextInt();
                    if(array[end_index-1]==1)
                        out.println("ODD");
                    else
                        out.println("EVEN");
                    break;
                }
                case 1:{
                    int X= in.nextInt();
                    array[X-1]=(array[X-1]+1)%2;
                }

            }
        }
    }
}
