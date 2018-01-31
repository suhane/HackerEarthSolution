package interviewBits.dynamicProgramming.top20;

public class DiceThrow {

    public static int sum(int m, int n, int x){

        int[][] dp= new int[n+1][x+1];

        for(int i=1;i<=m && i<=x;i++){
            dp[1][i]=1;
        }


        for(int i=2;i<=n;i++){
            for(int j=1;j<=x;j++){
                for(int k=1;k<=j && k<=m;k++){
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }

    return dp[n][x];
    }

}
