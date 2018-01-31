package interviewBits.strings;

import java.util.ArrayList;

/**
 * Created by labuser on 7/19/17.
 */
public class LongestPrefix {

    public static String longestCommonPrefix(ArrayList<String> a) {
        String out="";
        int n=a.size();
        if(n==1)
            return a.get(0);
        if(n==0)
            return "";
        String random=a.get(0);
        int l=0;
        int r=random.length();
        boolean stop=false;
        while(l<r && !stop ){
            stop=true;
            for(int i=1;i<n;i++) {
                if (l < a.get(i).length() && random.charAt(l) == a.get(i).charAt(l)){
                    stop = false;
                }
                else{
                    stop=true;
                    break;
                }
            }

                if(!stop){
                    out+=random.charAt(l++);
                }
                else{
                    break;
                }


        }
        return out;

    }
    public static void main(String args[]){
        ArrayList<String> in =new ArrayList<String>();
        in.add("abcd");
        in.add("abcd");
        in.add("efgh");
        longestCommonPrefix(in);
    }
}
