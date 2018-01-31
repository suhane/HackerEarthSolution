package interviewBits.dynamicProgramming.twoDStringDP;

public class LongestCommonSubsequence {

    public static String lcs(String a, String b) {

        int r=a.length();
        int c=b.length();
        int[][] dp=new int[r][c];

        int count=0;
        for(int i=0;i<c;i++){
            if(a.charAt(0)==b.charAt(i))
                count=1;
            dp[0][i]=count;
        }

        count=0;
        for(int i=0;i<r;i++){
            if(a.charAt(i)==b.charAt(0))
                count=1;
            dp[i][0]=count;
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }


            }
        }

        for(char ch: b.toCharArray()){
            System.out.print("\t"+ch);
        }
        System.out.println();
        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                if(j==0)
                    System.out.print(a.charAt(i)+ "\t");
                System.out.print(dp[i][j]+ "\t");

            }
            System.out.println();
        }

        char[] str=new char[dp[r-1][c-1]];
        int end=dp[r-1][c-1]-1;
        int i=r-1;
        int j=c-1;
        while(i>=0 && j>=0){
                if(a.charAt(i)==b.charAt(j)){
                    str[end--]=a.charAt(i);
                    i--;
                    j--;
                }
                else{
                    if(i==0)
                        j--;
                    else
                        if(j==0)
                            i--;
                    else
                        if(dp[i][j-1]>=dp[i-1][j])
                            j--;
                    else
                            i--;
                }

            }

        return new String(str);
    }

    public static void main(String args[]){
        System.out.println(lcs("aadbbcbcac","aabcc"));
    }

}
