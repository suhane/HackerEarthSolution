package interviewBits.arrayMath;

import com.sun.tools.classfile.Synthetic_attribute;

/**
 * Created by labuser on 7/16/17.
 */
public class ExcelColumnTitle {

    public static String convertToTitle(int a) {

        String output="";
        while(a>0){
            int mod=a%26;
            char c;
            if(mod==0)
                c='Z';
            else
                c= (char) (mod+64);
            output=c+output;
            a=a/26;
            if(a==1 && mod==0)
                return output;
        }


        return output;

    }
    public static void main(String args[]){
        System.out.println(convertToTitle(943566));
    }
}
