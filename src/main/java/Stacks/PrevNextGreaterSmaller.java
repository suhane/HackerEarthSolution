package Stacks;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class PrevNextGreaterSmaller {

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
        InputReader in= new PrevNextGreaterSmaller().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int N=in.nextInt();
        solve(in,out,N);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int n){

        int[] arr=new int[n];
        int[] nxtgreater=new int[n];
        int[] prevgreater=new int[n];
        int[] nxtsmaller=new int[n];
        int[] prevsmaller=new int[n];

        int index=0;
        while(index<n)
            arr[index++]=in.nextInt();

        printnextgreater(arr,nxtgreater);
        printprevgreater(arr,prevgreater);
        printnextsmaller(arr,nxtsmaller);
        printprevsmaller(arr,prevsmaller);


        System.out.println("Previous Smaller array is:");
        for(int i=0;i<n;i++){
            System.out.print(prevsmaller[i]+ " ");
        }

        System.out.println("Next Smaller array is:");
        for(int i=0;i<n;i++){
            System.out.print(nxtsmaller[i]+ " ");
        }

        System.out.println("Previous Greater array is:");
        for(int i=0;i<n;i++){
            System.out.print(prevgreater[i]+ " ");
        }

        System.out.println("Next greater array is:");
        for(int i=0;i<n;i++){
            System.out.print(nxtgreater[i]+ " ");
        }
    }

    private static void printprevsmaller(int[] arr, int[] prevsmaller) {

        Stack<Integer> s= new Stack<Integer>();
        int n = arr.length;
        s.push(n-1);

        for(int i=n-2; i>=0;i--){

            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                prevsmaller[s.pop()]=i;
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            prevsmaller[s.pop()]=-1;
        }

    }

    private static void printprevgreater(int[] arr, int[] prevgreater) {

        Stack<Integer> s= new Stack<Integer>();
        int n = arr.length;
        s.push(n-1);

        for(int i=n-2; i>=0;i--){

            while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                prevgreater[s.pop()]=i;
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            prevgreater[s.pop()]=-1;
        }
    }

    private static void printnextsmaller(int[] arr, int[] nxtsmaller) {

        Stack<Integer> s= new Stack<Integer>();
        int n = arr.length;
        s.push(0);

        for(int i=1; i<n;i++){

            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                nxtsmaller[s.pop()]=i;
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            nxtsmaller[s.pop()]=-1;
        }
    }

    private static void printnextgreater(int[] arr, int[] nxtgreater) {

        Stack<Integer> s= new Stack<Integer>();
        int n = arr.length;
        s.push(0);

        for(int i=1; i<n;i++){

            while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                nxtgreater[s.pop()]=i;
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            nxtgreater[s.pop()]=-1;
        }
    
    }
    
}
