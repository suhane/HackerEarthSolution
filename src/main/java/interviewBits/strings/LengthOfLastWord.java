package interviewBits.strings;

/**
 * Created by labuser on 7/22/17.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(final String a) {

        String test=a.trim();
        int n=test.length();
        int i=n-1;
        while(i>=0 && isAlphabet(test.charAt(i))){
            i--;
        }
        return test.substring(i+1,n).length();

    }

    private  static boolean isAlphabet(char c){
        return ((c>=65 && c<=90) || (c>=97 && c<=122));
    }


    public static void main(String args[]){

        System.out.print(lengthOfLastWord("a"));
    }
}
