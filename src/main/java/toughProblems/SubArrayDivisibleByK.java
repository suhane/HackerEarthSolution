package toughProblems;

/*
Input  : arr[] = {4, 5, 0, -2, -3, 1},
         K = 5
Output : 7
// there are 7 sub-arrays whose is divisible by K
// {4, 5, 0, -2, -3, 1}
// {5}
// {5, 0}
// {5, 0, -2, -3}
// {0}
// {0, -2, -3}
// {-2, -3}
 */

public class SubArrayDivisibleByK {

    public int subCount(int[] arr, int k){

        int n=arr.length;
        int cum_sum=0;
        int[] mod= new int[k];
        for(int i=0;i<n;i++){
            cum_sum+=arr[i];
            mod[cum_sum%k]++;
        }
        int count=0;
        for(int i=0;i<k;i++){
            if (mod[i] > 1) {
                count += (mod[i] * mod[i] - 1) / 2;
            }
        }

        count+=mod[0];
        return count;
    }

}
