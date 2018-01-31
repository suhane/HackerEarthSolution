package interviewBits.dynamicProgramming.twoDStringDP;

public class Regex2 {

    public static int isMatch(final String s, final String p) {

        int row=p.length();
        int col=s.length();
        boolean[][] dp= new boolean[row+1][col+1];
        dp[0][0]=true;
        int k=1;

        for(int i=1;i<=row;i++){
            if(i< row && p.charAt(i-1)!='*' && p.charAt(i)=='*'){
                dp[i][0]= dp[i-1][0];
            }
        }


        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){

                if(i< row && p.charAt(i-1)!='*' && p.charAt(i)=='*'){
                    dp[i][j]=s.charAt(j-1)==p.charAt(i-1) || dp[i-1][j];
                }
                else if((p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='.') && dp[i-1][j-1])
                        dp[i][j]=true;
                else
                    if(p.charAt(i-1)=='*' && (dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j]))
                        dp[i][j]=true;

            }
        }

        return dp[row][col]?1:0;
    }

    public static void main(String args[]){
        System.out.println(isMatch("ac","ab*c"));
    }
}
