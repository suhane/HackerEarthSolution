package interviewBits.dynamicProgramming.twoDStringDP;

public class LongestReapeatingSubsequence {

    public static int lrs(String a) {
        int size=a.length();
        int n=size;
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==a.charAt(j-1) && i!=j){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];

    }

    public static void main(String args[]){
        System.out.println(lrs("axxxy"));
    }
}
