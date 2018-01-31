package interviewBits.dynamicProgramming.twoDStringDP;

public class EditDistance {

    public int minDistance(String a, String b) {

        int r=a.length();
        int c=b.length();
        int[][] dp=new int[r+1][c+1];

        int count=0;
        for(int i=0;i<=c;i++)
            dp[0][i]=count++;
        count=0;
        for(int i=0;i<=r;i++)
            dp[i][0]=count++;

        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+ Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }


            }
        }

        return dp[r][c];


    }
}
