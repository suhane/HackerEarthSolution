package Amazob24thFebSDE2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class ZigzagMatrixTraversal {

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
        InputReader in= new ZigzagMatrixTraversal().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int n=in.nextInt();
        int m=in.nextInt();
        solve(in,out,n,m);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n, int m) {
        int[][] arr=new int[n][m];
        printMatrix(arr,n,m);
        System.out.println(arr[0][0]);
        int i=0,j=1;
        while(j<=m-1 && i<=n-1){
            while(!(j<0 || i>=n)){
                System.out.println(arr[i][j]);
                i++;
                j--;
            }
            if(i>n-1){
                i--;
                j+=2;
            }
            else
                j++;

            while(!(i<0 || j>=m)){
                System.out.println(arr[i][j]);
                i--;
                j++;
            }
            if(j>m-1) {
                i+=2;
                j--;
            }
            else
                i++;


        }
    }

    private static void printMatrix(int[][] arr, int n, int m) {
        int k=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=k;
                System.out.print(k++ + "      ");
            }
            System.out.println();
        }
    }
}
