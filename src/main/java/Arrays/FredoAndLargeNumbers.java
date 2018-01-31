package Arrays;

import java.io.*;
import java.util.*;

/**
 * Created by suhane on 10/2/16.
 */
public class FredoAndLargeNumbers {

    static HashMap<Long, Long> hm1 = new HashMap<Long, Long>();
    static ArrayList<Long> al=new ArrayList<Long>();
    static HashMap<Long,Long> hm=new HashMap<Long,Long>();

    static long max=1;
    class InputReader {
        BufferedReader br;
        StringTokenizer token;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            token = null;
        }

        public String next() {
            while (token == null || !token.hasMoreTokens()) {
                try {
                    token = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String args[]) {
        InputReader in = new FredoAndLargeNumbers().new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextLong();
            if (hm1.containsKey(arr[i])){
                long x=hm1.get(arr[i]);
                hm1.put(arr[i],  x+ 1);
                if(max<x+1)
                {
                    max=x+1;
                }
            }
            else{
                hm1.put(arr[i], 1L);
                al.add(arr[i]);
            }
        }


        for(int i=al.size()-1;i>=0;i--)
        {
            hm.put(hm1.get(al.get(i)),al.get(i));
        }

        int Q = in.nextInt();
        solve(in, out,Q);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int q) {

        while (q-- > 0) {
            int t = in.nextInt();
            Long f = in.nextLong();
            if(f>max) {
                out.println(0);
                continue;
            }
            if(f==max) {
                out.println(hm.get(f));
                continue;
            }
            switch (t) {
                case 0: {
                   int l=al.size();
                    int j=0;
                   while(j<l){
                       long el=al.get(j);
                       if(hm1.get(el)>=f){
                           out.println(el);
                           break;
                       }
                       else
                           j++;
                   }
                    break;
                }
                case 1: {
                    if(hm.containsKey(f)){
                        out.println(hm.get(f));
                    }
                    else
                        out.println(0);
                    break;
                }
            }
        }
    }

}
