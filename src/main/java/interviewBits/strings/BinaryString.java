package interviewBits.strings;

/**
 * Created by labuser on 7/27/17.
 */
public class BinaryString {
    public static String addBinary(String a, String b) {
        int lenA=a.length();
        int lenB=b.length();
        if(lenA>lenB){
            int i=0;
            while(i++<(lenA-lenB)){
                b="0"+b;
            }
        }
        else{
            int i=0;
            while(i++<(lenB-lenA)){
                a="0"+a;
            }
        }

        return add(a,b);

    }

    private static String add(String a, String b) {
        String output="";
        int n=a.length();
        int i=n-1;
        boolean carry=false;
        while(i>=0){
            if(a.charAt(i)!=b.charAt(i)){
                if(carry)
                    output="0"+output;
                else
                    output="1"+output;
            }
            else{
                if(carry){
                    output="1"+output;
                    if(a.charAt(i)=='0')carry=false;

                }
                else{
                    output="0"+output;
                    if(a.charAt(i)=='1')carry=true;
                }
            }
            i--;
        }
        if(carry)
            output="1"+output;
        return output;

    }

    public static void main(String s[]){
        System.out.print(addBinary("1010110111001101101000","1000011011000000111100110"));
    }
}
