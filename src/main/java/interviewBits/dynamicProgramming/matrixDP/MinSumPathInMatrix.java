package interviewBits.dynamicProgramming.matrixDP;

import java.util.ArrayList;

public class MinSumPathInMatrix {

    public static int minPathSum(ArrayList<ArrayList<Integer>> a) {

        int row=a.size();
        int col=a.get(0).size();
        int[][] dp= new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                dp[i][j]=a.get(i).get(j);

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++){
                if(i==0 && j==0)
                    continue;
                if(i==0)
                    dp[i][j]+=dp[i][j-1];
                else
                    if(j==0)
                        dp[i][j]+=dp[i-1][j];
                else
                    dp[i][j]+=Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[row-1][col-1];

    }

    public static void main(String s[]){
        int[] arr={1, 3, 2, 4 ,3, 1, 5, 6, 1};
        ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
        int count=0;
        for(int i=0;i<3;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++)
                temp.add(arr[count++]);
            a.add(temp);
        }
        System.out.print(minPathSum(a));
    }
}
