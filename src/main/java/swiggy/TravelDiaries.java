package swiggy;

import java.util.Scanner;

public class TravelDiaries {

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);

            int row=s.nextInt();
            int col=s.nextInt();
            int[][] dp=new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    dp[i][j]=s.nextInt();
                }
            }
            int val=2;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(dp[i][j]==1){
                        int left=j>0 && dp[i][j-1]>1?dp[i][j-1]:Integer.MAX_VALUE;
                        int right=j<col-1 && dp[i][j+1]>1?dp[i][j+1]:Integer.MAX_VALUE;
                        int top=i>0 && dp[i-1][j]>1?dp[i-1][j]:Integer.MAX_VALUE;
                        int bottom=i<row-1 && dp[i+1][j]>1?dp[i+1][j]:Integer.MAX_VALUE;
                        dp[i][j]+=Math.min(left,Math.min(right,Math.min(top,bottom)));
                        val=Math.max(dp[i][j],val);
                    }
                }
            }
            System.out.println(val-2);


    }
}
