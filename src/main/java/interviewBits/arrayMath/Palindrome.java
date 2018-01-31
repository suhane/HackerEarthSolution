package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class Palindrome {

    public static boolean isPalindrome(int a) {

        if(a<0)
            return false;

        int digit=isDigit(a);
        while(digit>0){
            int temp= (int) (a/Math.pow(10,digit-1));
            if(temp!=a%10)
                return false;
            a= (int) (a- temp* Math.pow(10,digit-1));
            a=a/10;
            digit-=2;
        }
        return true;
    }

    private static int isDigit(int a) {
        int digit=0;
        while(a!=0){
            digit++;
            a=a/10;
        }
        return digit;
    }

    public static void main(String s[]){
        isPalindrome(5225);
    }
}
