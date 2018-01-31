package interviewBits.dynamicProgramming.top20;

public class RodCuttingProblem {


    //recursive approach

    public static int getMaxCost(int[] cost, int n){
        if(n<=0)
            return 0;

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,cost[i]+getMaxCost(cost,n-i-1));
        }
        return max;
    }

    public static int getMaxCost(int[] cost){
        int n=cost.length;
        int[] dp= new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            dp[i]=0;
            for(int j=0;j<i;j++){
                dp[i]=Math.max(dp[i],cost[j]+dp[i-j-1]);
            }
        }

        return dp[n];
    }

    public static void main(String s[]){

        int[] cost={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxCost(cost));
    }
}
