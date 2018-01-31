package swiggy;

import java.util.Scanner;

public class MatrixAndVolume {

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        while(N-->0){
            long area=0;
            int x=s.nextInt();
            int y=s.nextInt();
            int z=s.nextInt();
            int row=x*z;
            int col=y;
            int[][] dp=new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    dp[i][j]=s.nextInt();
                }
            }

            for(int i=1;i<row-1;i++){
                for(int j=1;j<col-1;j++){
                    if(dp[0][j]==1 && dp[i][0]==1 && dp[row-1][j]==1 && dp[i][col-1]==1 && dp[i][j]==0 )
                        area++;
                }
            }
            System.out.println(area);

        }
    }
}
