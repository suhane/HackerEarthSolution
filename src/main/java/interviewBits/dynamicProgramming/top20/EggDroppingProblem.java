package interviewBits.dynamicProgramming.top20;
/*

* You are given 2 eggs.
* You have access to a 100-storey building.
* Eggs can be very hard or very fragile means it may break if dropped from the first floor or may not even break if dropped from 100 th floor.Both eggs are identical.
* You need to figure out the highest floor of a 100-storey building an egg can be dropped without breaking.
* Now the question is how many drops you need to make. You are allowed to break 2 eggs in the process

If only one egg is available and we wish to be sure of obtaining the right result,
the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives,
drop it from the second floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings.
Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?

The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.


 */


public class EggDroppingProblem {

    public static int minimumTrialsForEggDrop(int n, int k){

        int[][] dp=new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            dp[i][0]=0;
            dp[i][1]=1;
        }

        for(int i=1;i<=k;i++){
           dp[1][i]=i;
        }


        for(int i=2;i<=n;i++){


            for(int j=2;j<=k;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    dp[i][j]=Math.min(1+Math.max(dp[i-1][x-1],dp[i][j-x]),dp[i][j]);
                }
            }

        }
        return dp[n][k];
    }

    public static void main(String args[]){
        System.out.println(minimumTrialsForEggDrop(2,100));
    }
}
