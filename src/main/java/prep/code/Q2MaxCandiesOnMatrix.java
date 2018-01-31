package prep.code;

import java.util.ArrayList;

public class Q2MaxCandiesOnMatrix {

    public int maxcandies(ArrayList<ArrayList<Integer>> a){
        int row=a.size();
        int col=a.get(0).size();
        int[][] dp= new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 && j==0)
                    continue;
                if(i==0){
                    dp[0][j]=dp[0][j-1]+a.get(0).get(j);
                }
                else if(j==0){
                    dp[i][0]=dp[i-1][0]+a.get(i-1).get(0);
                }
                else {
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+ a.get(i).get(j);
                }
            }
        }

        return dp[row-1][col-1];
    }
}
