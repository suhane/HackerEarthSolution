package Arrays;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class AmazingRace {

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
        InputReader in= new AmazingRace().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int N){
        int count=0;
        while(N-->0){
            int n=in.nextInt();
            int index=0;
            int[] arr=new int[n];
            while(index<n) {
                arr[index++] = in.nextInt();
            }
            int[] leftmax=new int[n];
            int[] rightmax= new int[n];
            leftmax[0]=0;
            rightmax[n-1]=n-1;
            for(int i=n-2;i>=0;i--){

                if(arr[i+1]>=arr[i]){
                    rightmax[i]=i+1;
                }
                else{
                    int nextMaxIndex=rightmax[i+1];
                    int nextMaxValue=arr[nextMaxIndex];
                    while(nextMaxValue<arr[i] && nextMaxIndex!=n-1){
                        nextMaxIndex=rightmax[nextMaxIndex];
                        nextMaxValue=arr[nextMaxIndex];
                    }
                    rightmax[i]=nextMaxIndex;
                }


            }

            for(int i=1;i<n;i++){

                if(arr[i-1]>=arr[i]){
                    leftmax[i]=i-1;
                }
                else{
                    int nextMaxIndex=leftmax[i-1];
                    int nextMaxValue=arr[nextMaxIndex];
                    while(nextMaxValue<arr[i] && nextMaxIndex!=0){
                        nextMaxIndex=leftmax[nextMaxIndex];
                        nextMaxValue=arr[nextMaxIndex];
                    }
                    leftmax[i]=nextMaxIndex;
                }


            }

            int maxsight=Integer.MIN_VALUE;
            int maxsightIndex=0;
            for(int i=0;i<n;i++){
                int frontdrivers=rightmax[i]-i;
                int backdrivers=i-leftmax[i];
                int X=frontdrivers+backdrivers;
                int sight=X*(i+1);

                if(maxsight<=sight){
                    maxsight=sight;
                    maxsightIndex=i;
                }

            }
            out.println(maxsightIndex+1);

        }

    }
}
