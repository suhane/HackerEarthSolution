package interviewBits.strings;

/**
 * Created by labuser on 7/20/17.
 */
public class KMPAlgorithm {

    private static int[] generateLPS(String s){
        int n=s.length();
        int[] lps=new int[n];
        lps[0]=0;
        int i=1;
        int len=0;
        while (i < n)
        {
            if (s.charAt(i) == s.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];

                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }

    public static int strStr(final String haystack, final String needle) {
        int[] lps=generateLPS(needle);
        int n=haystack.length();
        int m=needle.length();
        int i=0;
        int j=0;
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else if(j==m){
                return i-j;
            }
            else{
                if(j!=0)
                    j=lps[j-1];
                else
                    i++;
            }

        }
        return -1;

    }

    public static void main(String s[]){
        //generateLPS("ABABABCABABABCABABABC");
        strStr("ABABABCABABABCABABABC","ABABAC");
    }
}
