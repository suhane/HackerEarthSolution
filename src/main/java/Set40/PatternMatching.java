package Set40;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class PatternMatching {

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
        InputReader in= new PatternMatching().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        String text=in.next();
        String pattern=in.next();
        solve(in,out,text,pattern);
        out.close();
        System.exit(0);
    }

    private static boolean solve(InputReader in, PrintWriter out, String str, String pattern){
        // Function that matches input str with
        // given wildcard pattern
            int n=str.length();
            int m=pattern.length();
            // empty pattern can only match with
            // empty string
            if (m == 0)
                return (n == 0);

            // lookup table for storing results of
            // subproblems
            boolean[][]  lookup=new boolean[n + 1][m + 1];

            // empty pattern can match with empty string
            lookup[0][0] = true;

            // Only '*' can match with empty string
            for (int j = 1; j <= m; j++)
                if (pattern.charAt(j - 1) == '*')
                    lookup[0][j] = lookup[0][j - 1];

            // fill the table in bottom-up fashion
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= m; j++)
                {
                    // Two cases if we see a '*'
                    // a) We ignore ‘*’ character and move
                    //    to next  character in the pattern,
                    //     i.e., ‘*’ indicates an empty sequence.
                    // b) '*' character matches with ith
                    //     character in input
                    if (pattern.charAt(j - 1) == '*')
                        lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

                        // Current characters are considered as
                        // matching in two cases
                        // (a) current character of pattern is '?'
                        // (b) characters actually match
                    else
                        if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                            lookup[i][j] = lookup[i - 1][j - 1];

                        // If characters don't match
                        else
                            lookup[i][j] = false;
                }
            }

            return lookup[n][m];

    }
}
