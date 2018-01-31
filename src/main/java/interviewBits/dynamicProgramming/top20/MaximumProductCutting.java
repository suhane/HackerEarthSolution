package interviewBits.dynamicProgramming.top20;

public class MaximumProductCutting {

    public static int maxProduct(int n){

        int[] dp=new int[n+1];

        dp[0]=dp[1]=1;


        for(int i=2;i<=n;i++){
            dp[i]=0;
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],Math.max((i-j)*j, dp[i-j]*j));
            }
        }

        return dp[n];


    }

    public static void main(String s[]){
        System.out.println(maxProduct(10));
    }
}
