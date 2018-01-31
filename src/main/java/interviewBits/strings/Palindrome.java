package interviewBits.strings;

/**
 * Created by labuser on 7/18/17.
 */
public class Palindrome {
    public static int isPalindrome(String a) {
        int len=a.length();
        int r=len-1;
        int l=0;
        while(l<r){
            r=rightGoodIndex(a,r,l);
            l= leftGoodIndex(a,l,r);
            if((r==-1 && l!=-1) || (r!=-1 && l==-1)) return 0;
            char c1=a.charAt(r);
            char c2=a.charAt(l);
            if(c1-c2==0 || Math.abs(c1-c2)==32){
                l++;
                r--;
            }else
                return 0;

        }
        return 1;
    }

    public static int isPalindrome2(String a) {
        int len=a.length();
        int r=len-1;
        int l=0;
        while(l<r){
            char left=a.charAt(l);
            char right=a.charAt(r);
            if(!isAlphabet(left))
                l++;
            else
                if(!isAlphabet(right))
                    r--;
            else
                if(left-right==0 || Math.abs(left-right)==32){
                    l++;
                    r--;
                }
            else return 0;
        }
        return 1;
    }

    private static boolean isAlphabet(char c){
        return ((c>=65 && c<=90) || (c>=97 && c<=122) || (c>=48 && c<=57));
    }

    private static int rightGoodIndex(String s,int r,int l) {
        char c=s.charAt(r);
        while(!((c>=65 && c<=90) || (c>=97 && c<=122))){
            r--;
            if(l==r)
                return -1;
            c=s.charAt(r);
        }
        return r;
    }

    private static int leftGoodIndex(String s,int l,int r) {

        char c=s.charAt(l);
        while(!((c>=65 && c<=90) || (c>=97 && c<=122))){
            l++;
            if(l==r)
                return -1;
            c=s.charAt(l);
        }
        return l;
    }

    public static void main(String s[]){
        int test= isPalindrome2("1a2");
    }
}
