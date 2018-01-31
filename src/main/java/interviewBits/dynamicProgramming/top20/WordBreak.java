package interviewBits.dynamicProgramming.top20;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

    private  static ArrayList<String> dict= new ArrayList<String>(Arrays.asList("mobile","samsung","sam","sung",
            "man","mango","icecream","and",
            "go","i","like","ice","cream"));
    public static boolean workBreak(String str){

        int length=str.length();

        boolean[] dp= new boolean[length+1];

        for(int i=1;i<=length;i++){

            if(dp[i]==false && isValid(str.substring(0,i)))
                dp[i]=true;

            if(dp[i]==true){

                if (i == length)
                    return true;

                int j;
                for(j=i+1;j<=length;j++){

                    if(!dp[j] && isValid(str.substring(i,j)))
                        dp[j]=true;
                }

                if(j==length && dp[j])
                    return true;

            }
        }
        return false;

    }

    private static boolean isValid(String s){

        for(String str:dict){
            if (str.equals(s)) return true;
        }
        return false;
    }


    public static void main(String s[]){
        System.out.println(workBreak("iliksamsung"));
    }
}
