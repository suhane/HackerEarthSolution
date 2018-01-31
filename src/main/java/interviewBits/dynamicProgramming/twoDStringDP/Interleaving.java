package interviewBits.dynamicProgramming.twoDStringDP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interleaving {

    public  static int isInterleave(String a, String b, String c) {

        if(c.length()!=a.length()+b.length())
            return 0;
        int row=a.length();
        int col=b.length();
        boolean[][] dp= new boolean[row+1][col+1];

        dp[0][0]=true;

        for(int column=1;column<=col;column++){

            if( b.charAt(column-1)==c.charAt(column-1))
                dp[0][column]=true;
            else
                break;
        }

        for(int i=1;i<=row;i++){

            if( a.charAt(i-1)==c.charAt(i-1))
                dp[i][0]=true;
            else
                break;
        }

        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){

                //a match do does not match
                if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)!=c.charAt(i+j-1)){
                    dp[i][j]=dp[i-1][j];
                }

                else if(a.charAt(i-1)!=c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)){
                    dp[i][j]=dp[i][j-1];
                }
                else
                    if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)){
                        dp[i][j]=(dp[i][j-1] || dp[i-1][j]);
                    }


            }
        }
        if(dp[row][col])
            return 1;
        else
            return 0;




    }

    public static void main(String s[]){

        System.out.println(isInterleave("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh","Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf","Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh"));
    }
}
