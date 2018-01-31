package interviewBits.dynamicProgramming.top20;

/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a

Steps:
1. Identify Sub problems: Edit distance in x[i:] and y[i:] for all i,j
    number of sub problems= O(|x|*|y|)
2. Any one of the three possibilities -
    i) replace x[i] -> y[j]  (we will advance in both the strings)
    ii) insert y[j] (we will advance one step in the y )
    iii) delete x[i] (we will advance one step in x)
3. dp(i,j)= min(
                   cost of x[i]->y[j] + dp(i-1,j-1),
                   cost of insert y[j] + dp(i,j-1)
                   cost of delete x[i] + dp(i-1,j)
                )
4. Topological order: bottom up from 0 to |x| from 0 to |y|





 */

public class EditDistanceAndLCS {

    public static int getMinCost(String str1,int m, String str2 ,int n){

        if(m==0)
            return n;
        if(n==0)
            return m;

        if(str1.charAt(m-1)==str2.charAt(n-1))
            return getMinCost(str1,m-1,str2,n-1);

        return 1+Math.min(
                getMinCost(str1,m-1,str2,n-1),
                Math.min(
                        getMinCost(str1,m,str2,n-1),
                        getMinCost(str1,m-1,str2,n)
                )

        );
    }

    public static int getMinCost(String str1, String str2){

        int m=str1.length();
        int n=str2.length();
        int[][] dp= new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j]=1 +Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[m][n];

    }

    public static int lcs(String str1, String str2){

        int m=str1.length();
        int n=str2.length();
        int[][] dp= new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[m][n];

    }

    public static void main(String args[]){
        System.out.println(getMinCost("sunday",6,"saturday",8));
        System.out.println(getMinCost("sunday","saturday"));
        System.out.println(lcs("hieroglyphollgy","michelangelo"));
    }
}
