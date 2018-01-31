package interviewBits.strings;

/**
 * Created by labuser on 7/19/17.
 */
public class PalindromicString {
    public static int solve(String A) {
        int l=A.length();
        int i=l-1;
        int count=0;
        while(i>=0){
            if(!isPalindrome(A,i)) {
                i--;
                count++;
            }
            else return count;
        }
        return count;
    }

    private static boolean isPalindrome(String s, int offset){
        int i=0;
        while(i<offset){
            if(s.charAt(i)!=s.charAt(offset))
                return false;
            i++;
            offset--;
        }
        return true;
    }

    public static void main(String s[]){
        solve("ABC");
    }
}
