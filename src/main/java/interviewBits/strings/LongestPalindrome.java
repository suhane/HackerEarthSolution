package interviewBits.strings;

/**
 * Created by labuser on 7/19/17.
 */
public class LongestPalindrome {

    public static String longestPalindrome(String a) {
        int n=a.length();
        boolean[][] palindrome=new boolean[n][n];
        for(int i=0;i<n;i++){
            palindrome[i][i]=true;
        }
        int start=0;
        int maxIndex=0;
        for(int i=0;i<n-1;i++){
            if(a.charAt(i)==a.charAt(i+1)) {
                palindrome[i][i + 1] = true;
                start = i;
                maxIndex = 1;
            }
        }

        for (int k = 2; k < n; ++k)
        {
            // Fix the starting index
            for (int i = 0; i < n-k ; ++i)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k;

                // checking for sub-string from ith index to
                // jth index iff str[i+1] to str[j-1] is a
                // Palindrome
                if (palindrome[i+1][j-1] && a.charAt(i) == a.charAt(j))
                {
                    palindrome[i][j] = true;

                    if (k > maxIndex)
                    {
                        start = i;
                        maxIndex = k;
                    }
                }
            }
        }
        return a.substring(start,start+maxIndex+1);




    }

    public static void main(String s[]){
        System.out.println(longestPalindrome("bbaabb"));
    }
}
