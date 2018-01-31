package interviewBits.strings;

/**
 * Created by labuser on 7/20/17.
 */
public class StrStr {

    private static int R=256;

    public static int strStr(final String haystack, final String needle) {

        int N = haystack.length();
        int M = needle.length();
        if (N < M) return -1;
        long RM = 1;
        for (int i = 1; i <= M-1; i++)
            RM = (R * RM);
        long txtHash = hash(haystack, M);
        long needleHash = hash(needle, M);
        /** check for match at start **/
        if ((needleHash == txtHash) && check(haystack,needle, 0))
            return 0;
        /** check for hash match. if hash match then check for exact match**/
        for (int i = M; i < N; i++)
        {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = txtHash  - RM * haystack.charAt(i - M);
            txtHash = txtHash * R + haystack.charAt(i);
            // match
            int offset = i - M + 1;
            if ((needleHash == txtHash) && check(haystack,needle, offset))
                return offset;
        }
        /** no match **/
        return -1;
    }

    /** Funtion check **/
    private static boolean check(String txt, String sub, int i)
    {
        int M=sub.length();
        for (int j = 0; j < M; j++)
            if (sub.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    /** Compute hash **/
    private  static long hash(String key, int M)
    {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = R * h + key.charAt(j);
        return h;
    }

    public static void main(String s[]){
        System.out.print(strStr("bbbbba","bbbba"));
    }
}
