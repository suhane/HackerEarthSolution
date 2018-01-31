package interviewBits.dynamicProgramming.top20;
/*
The Longest Increasing Sub sequence (LIS) problem is to find the length of the longest sub sequence of a given sequence such that
all elements of the sub sequence are sorted in increasing order.
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

Steps:

1. Identify sub problems: L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
3. Recurrence relationship
           Lis(i)= {
                1 + max( Lis(j) ) where 0 < j < i and arr[j] < arr[i]; or
                1 if no such j exists

                for i in range (0...n-1)
           }
   Running time excluding recursion per sub problem= O(n)

4. Topological order: Bottom up
total running time=O(n2)




 */

public class LIS {

    static int max_ref=0;


    public static int lis(int[] arr, int n){
        if(n<=1)
            return n;
        int res, max_ending_here = 1;
        for(int i=1;i<n;i++){
            res=lis(arr,i);
            if(arr[i-1]<arr[n-1])
                max_ending_here=Math.max(max_ending_here,res+1);
        }
        max_ref=Math.max(max_ref,max_ending_here);
        return max_ending_here;

    }

    public static int lis(int[] arr){
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;


        for(int i=2;i<=n;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){
                if(arr[j-1]<arr[i-1])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }


        }
        return dp[n];
    }

    public static void main(String s[]) {
        int arr[] = { 10 };

        lis(arr,arr.length);
        System.out.println(max_ref);
        System.out.println(lis(arr));
    }
}
