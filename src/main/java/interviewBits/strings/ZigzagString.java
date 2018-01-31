package interviewBits.strings;

/**
 * Created by labuser on 7/27/17.
 */
public class ZigzagString {

    public static String convert(String a, int b) {
        int n=a.length();
        if(n<=1 || b<=1)
            return a;
        int i=0;
        String output="";
        while(i<b){

            boolean flip=false;

            for(int j=i;j<n;){
                output+=a.charAt(j);
                int elementsToskip;
                if(i==0 || i==b-1){
                    elementsToskip=2*(b-1);
                }
                else{
                    if(!flip){
                        elementsToskip=2*(b-i-1);
                        flip=true;
                    }
                    else {
                        elementsToskip = 2 * i;
                        flip=false;
                    }
                }
                j+=elementsToskip;
            }
            i++;
        }
        return output;
    }

    public static void main(String s[]){
        System.out.print(convert("ABCD",2));
    }
}
