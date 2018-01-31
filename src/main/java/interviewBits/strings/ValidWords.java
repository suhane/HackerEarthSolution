package interviewBits.strings;

/**
 * Created by labuser on 7/21/17.
 */
public class ValidWords {
    public static int isNumber(final String a) {
        String test=a.trim();
        if(test.length()>0 && (test.charAt(0)=='+' || test.charAt(0)=='-'))
            test=test.substring(1);
        String[] arr=test.split("\\.");
        if(arr.length>2 || containDot(test) && arr.length==1)
            return 0;
        if(arr.length==1){
            return validateAll(arr[0]);
        }
        else{
            if(validateDigits(arr[0])==0) return 0 ;
            if(validateAll(arr[1])==0) return 0 ;

        }

        return 1;



    }

    private static int validateAll(String a) {
        int l=a.length();
        if(l==0)
            return 0;
        boolean exponentfound=false;
        for(int i=0;i<l;i++){

            if(i>0 && i<l-1 && a.charAt(i)=='e' && isDigit(a.charAt(i+1)) && !exponentfound){
                i+=1;
                exponentfound=true;
                continue;
            }


            if(i>0 && i<l-2 && a.charAt(i)=='e'  && (a.charAt(i+1)=='+' || a.charAt(i+1)=='-') && isDigit(a.charAt(i+2)) &&!exponentfound){
                i+=2;
                exponentfound=true;
                continue;
            }
            if (!isDigit(a.charAt(i))) return 0;
        }
        return 1;
    }

    private static int validateDigits(String a) {
        for(char c:a.toCharArray()){
            if(!isDigit(c)) return 0;
        }
        return 1;
    }

    private static boolean containDot(String a) {
        for(char c:a.toCharArray()){
            if(c=='.') return true;
        }
        return false;
    }



    private static boolean isDigit(char c){
        return (c>=48 && c<=57);
    }

    public static void main(String args[]){

        System.out.print(isNumber("   11.111  "));
    }
}
