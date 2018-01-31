package expedia;

import org.junit.Test;

public class LongestSubseqWithDiffZeroOrOne {


    public int findLongestSubSeq(int[] arr){

        int length= arr.length;
        int[] lss=new int[length];
        int result=Integer.MIN_VALUE;
        for(int i=1;i<length;i++){
            int j=0;
            while (j<i){
                if(Math.abs(arr[i]-arr[j])==1 || Math.abs(arr[i]-arr[j])==0){
                    if(lss[j]==0)
                        lss[i]=Math.max(2,lss[i]);
                    else
                        lss[i]=Math.max(lss[j]+1,lss[i]);
                }
                j++;
            }
            result=Math.max(result,lss[i]);
        }
        return result;


    }


    @Test
    public void test(){
        int[] arr={2, 5, 6, 3, 7, 6, 5, 8};
        System.out.println(findLongestSubSeq(arr));
    }

    @Test
    public void test2(){
        int[] arr={-2, -1, 5, -1, 4, 0, 3};
        System.out.println(findLongestSubSeq(arr));
    }

}
