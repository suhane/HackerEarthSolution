package interviewBits.strings;

/**
 * Created by labuser on 7/21/17.
 */
public class Atoi {

    public static int atoi(final String a) {

        String test=a.trim();
        String max="2147483647";
        String min="2147483648";
        boolean isPositive=true;
        if(test.length()>0 && (test.charAt(0)=='+' || test.charAt(0)=='-')){
            if(test.charAt(0)=='-')
                isPositive=false;
            test=test.substring(1);
        }
        int n=test.length();
        if(n==0)
            return 0;
        int i=0;
        while(i<n && isDigit(test.charAt(i))){
            i++;
        }
        if(i==0)
            return 0;
        test=test.substring(0,i);

        if(isPositive){
            if(compare(test,max)<0)
                return Integer.parseInt(test);
            else
                return Integer.MAX_VALUE;
        }
        else{
            if(compare(test,min)<0)
                return -Integer.parseInt(test);
            else
                return Integer.MIN_VALUE;
        }

    }
    private static boolean isDigit(char c){
        return (c>=48 && c<=57);
    }

    private static int compare(String a, String b){
        if(a.equals(b)) return 0;
        if(a.length()==b.length())return a.compareTo(b);
        return a.length()<b.length()?-1:1;
    }

    public static void main(String args[]){

        System.out.print(atoi("     +17    "));
    }
}
