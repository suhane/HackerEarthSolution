package Arrays;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class UniqueSubarrays {

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
        InputReader in= new UniqueSubarrays().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        int T=in.nextInt();
        solve(in,out,T);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int t) {
    while(t-->0){
        int n=in.nextInt();
        int[] a=new int[n];
        int i=0;
        while(i<n){
            a[i++]=in.nextInt();
        }
        long res=0;
        int l=0,r=0;
        Set<Integer> set = new HashSet<Integer>();
        HashMap<Integer,Integer> cnt= new HashMap<Integer,Integer>();
        while ( l < n ) {
            while ( r < n && !set.contains(a[r]) ) {
                set.add(a[r]);
                r++;
            }
            res += (1L*(r - l)*(r - l + 1))/2;
            set.remove(a[l++]);
        }
        out.println(res);
    }

    }
}
