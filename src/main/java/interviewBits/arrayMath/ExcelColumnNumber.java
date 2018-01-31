package interviewBits.arrayMath;

/**
 * Created by labuser on 7/16/17.
 */
public class ExcelColumnNumber {
    public static int titleToNumber(String a) {

        char[] arr=a.toCharArray();
        int n=arr.length;
        int num=0;
        for(int i= n-1;i>=0;i--){
            char c=arr[i];
            num+=Math.pow(26,n-i-1)*((c>=65 && c<=91)?c-64:c-48);
        }
        return num;
    }

    public static void main(String args[]){
        titleToNumber("Z");
    }
}
