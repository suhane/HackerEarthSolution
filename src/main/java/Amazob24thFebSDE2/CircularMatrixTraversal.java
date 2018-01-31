package Amazob24thFebSDE2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class CircularMatrixTraversal {

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
        InputReader in= new CircularMatrixTraversal().new InputReader(System.in);
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
        int rowStart=0,colStart=0;
        int rowEnd=n-1,colEnd=m-1;
        int i,j;
        while(rowStart<rowEnd && colStart<colEnd){

            for(i=rowStart,j=colStart;j<=colEnd;j++){
                System.out.println(arr[i][j]);
            }
            for(i=rowStart+1,j=colEnd;i<=rowEnd;i++){
                System.out.println(arr[i][j]);
            }
            for(i=rowEnd,j=colEnd-1;j>=colStart;j--){
                System.out.println(arr[i][j]);
            }
            for(i=rowEnd-1,j=colStart;i>=rowStart+1;i--){
                System.out.println(arr[i][j]);
            }
            rowStart++;colStart++;rowEnd--;colEnd--;
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
