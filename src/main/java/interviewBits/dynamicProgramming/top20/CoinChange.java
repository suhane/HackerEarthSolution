package interviewBits.dynamicProgramming.top20;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5.


To count total number solutions, we can divide all set solutions in two sets.
1) Solutions that do not contain mth coin (or Sm).
2) Solutions that contain at least one Sm.
Let count(S[], m, n) be the function to count the number of solutions,
then it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).
 */

import java.util.ArrayList;

public class CoinChange {

    public static int countWays(ArrayList<Integer> a, int n){

        int m=a.size();
        int[] ways= new int[n+1];
        ways[0]=1;
        for (int i=0; i<m; i++){
            int j=a.get(i);
            // Pick all coins one by one and update the table[]
            // values after the index greater than or equal to
            // the value of the picked coin
            while(j<=n){
                ways[j]= ways[j]+ways[j-a.get(i)];
                j++;
            }
        }

        return ways[n];
    }
}
