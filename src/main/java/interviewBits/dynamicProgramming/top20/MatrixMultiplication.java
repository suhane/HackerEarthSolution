package interviewBits.dynamicProgramming.top20;
/*
Problem: Optimal evaluation of associative expression A0.A1.A2.-----.An-1

We need to choose the correct sequence of pairwise multiplication

Steps:

1. Identify Sub problem: Sub problem is going to be the optimal evaluation of (Ai.Aj-1). Number of subproblem=O(n2)
2. Guess: Whats the outermost/last multiplication

    (Ai....Ak-1).(Ak.....Aj-1)

    if somehow we know the optimal way to do Ai to Ak-1 and the optimal way to do Ak to Aj-1 then we are good

Number of choices for k is O(n)

3. Recurrence Relationship

DP(i,j)= Min(  DP(i,k) + DP(k,j)+ Cost of (A(i:k).A(k:j))

                for k in range (i+1,j)
            )

Time per Sub problem= O(n)

4. Topological order: its increasing substring size
total running time=O(n3)

 */
public class MatrixMultiplication {

    public static int matrixChainOrder(int[] arr, int i, int j){

        if (j-i<=1)
            return 0;

        int ans=Integer.MAX_VALUE;
        for (int k=i+1; k<j; k++){

            ans=Math.min(ans,
                    matrixChainOrder(arr,i,k)
                            +matrixChainOrder(arr,k,j)
                               + arr[i]*arr[k]*arr[j]
                    );
        }
        return ans;

    }

    public static int matrixChainOrder(int[] arr){
        int n=arr.length;
        int[][] dp= new int[n][n];


        for(int gap=2;gap<n;gap++) {

            for (int i = 0; i <n-gap;i++) {
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k]
                                    + dp[k][j]
                                    + arr[i] * arr[k] * arr[j]
                    );
                }
            }


        }

        return dp[0][n-1];


    }

    public static void main(String args[])
    {
        int arr[] = new int[] {1, 2, 3,4,5};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "+
                matrixChainOrder(arr));

    }


}
