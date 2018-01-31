package Amazob24thFebSDE2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class BitWiseXOR {

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
        InputReader in= new BitWiseXOR().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        //int T=in.nextInt();
        //solve(in,out,T);
        int ans=findXOR(1,2);
        int ans1=findXOR(1,ans);
        int ans2=findXOR(ans1,2);
        out.close();
        System.exit(0);
    }

    private static int findXOR(int x, int y) {
        return (x | y) & (~x | ~y);
    }

    private static int computeXOR(int[] arr, int start ,int end){

        if(end==start)
            return arr[start];
        int ans=findXOR(arr[start],arr[start+1]);
        for(int i=start+2;i<=end;i++){
            ans=findXOR(arr[i],ans);
        }
        return ans;
    }

    private static void solve(InputReader in, PrintWriter out, int t){
        int count=0;
        while(t-->0){
            int n=in.nextInt();
            int index=0;
            int[] arr=new int[n];
            while(index<n) {
                arr[index++] = in.nextInt();
            }
            int ans=arr[0];
            for(int indices=1;indices<=n;indices++){
                computeForIndex(arr,n,indices);

            }

        }

    }

    private static void computeForIndex(int[] arr, int n, int indices) {}
}
