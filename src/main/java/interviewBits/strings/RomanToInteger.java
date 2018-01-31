package interviewBits.strings;

/**
 * Created by labuser on 7/22/17.
 */
public class RomanToInteger {
    public static int romanToInt(String a) {
        int output=0;
        int n=a.length();
        for(int i=0;i<n;i++){
            int num;
            if(i<n-1 && equivalentInt(a.charAt(i))<equivalentInt(a.charAt(i+1))){
                output-=equivalentInt(a.charAt(i));
            }
            else
                output+=equivalentInt(a.charAt(i));

        }
        return output;

    }


    private static int equivalentInt(char c){

        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'M':
                return 1000;
            case 'C':
                return 100;
            case 'D':
                return 500;

        }
        return 0;
    }

    public static void main(String args[]){

        System.out.print(romanToInt("MDCCCIV"));
    }
}
