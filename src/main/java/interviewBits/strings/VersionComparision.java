package interviewBits.strings;

/**
 * Created by labuser on 7/21/17.
 */
public class VersionComparision {

    public static int compareVersion(String a, String b) {

        String[] A=a.split("\\.");
        String[] B=b.split("\\.");

        int lA=A.length;
        int lB=B.length;

        int n=Math.max(lA,lB);



        for(int i=0;i<n;i++){
            String x,y;
            if(i!=0) {

                x = i<lA?removeTrailingZeroes(A[i]):"0";
                y = i<lB?removeTrailingZeroes(B[i]):"0";
            }
            else{
                x = removeLeadingZeroes(A[i]);
                y = removeLeadingZeroes(B[i]);
            }
            if(compare(x,y)==0)
                continue;
            else
                return compare(x,y)<0?-1:1;

        }

        return 0;



    }



    private static int compare(String a, String b){
        if(a.equals(b)) return 0;
        if(a.length()==b.length())return a.compareTo(b);
        return a.length()<b.length()?-1:1;
    }

    private static String removeTrailingZeroes(String s) {
        //remove trailing zeroes
        int i=s.length()-1;
        while(i>0 && s.charAt(i)=='0')
            i--;
        s=s.substring(0,i+1);
        return s;


    }
    private static String removeLeadingZeroes(String s) {
        //remove trailing zeroes
        int i=0;
        while(i<s.length() && s.charAt(i)=='0')
            i++;
        s=s.substring(i);
        return s;


    }

    public static void main(String s[]){
        System.out.print(compareVersion("13.0","13.0.8"));
    }

}
