package interviewBits.dynamicProgramming.top20;

public class SubSetSum {

    public static boolean isSubsetSum(int[] arr,int n, int sum){

        if(sum==0)
            return true;

        if(n<=0 && sum!=0)
            return false;

        if(arr[n-1]>sum)
            return isSubsetSum(arr,n-1, sum);

        return isSubsetSum(arr,n-1,sum) || isSubsetSum(arr,n-1, sum-arr[n-1]);
    }


    public static boolean isSubsetSum(int[] arr,int sum){

        int n=arr.length;
        boolean[][] dp=new boolean[sum+1][n+1];

        for(int i=0;i<=n;i++){
            dp[0][i]=true;
        }

        for(int i=1;i<=sum;i++){
            dp[i][0]=false;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i][j-1];

                if(i>=arr[j-1]){
                    dp[i][j]=dp[i][j] || dp[i-arr[j-1]][j-1];
                }

            }
        }

        return dp[sum][n];


    }


    public static void main(String s[]){
        int[] arr= {1,5,5,11};
        System.out.println(isSubsetSum(arr,11));
    }
}
