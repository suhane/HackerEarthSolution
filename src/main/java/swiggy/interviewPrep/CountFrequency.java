package swiggy.interviewPrep;

import org.junit.Test;

public class CountFrequency {

    public void countFrequency(int[] arr) {

        int n=arr.length;

        for(int i=0;i<n;i++){
            int lastIndex=findLastOccurence(arr,i,n-1);
            int freq=lastIndex-i+1;
            System.out.println(arr[i] + " -> "+freq);
            i+=freq-1;
        }

    }

    private int findLastOccurence(int[] arr, int start, int end) {

        int num=arr[start];
        int low=start;
        int high=arr.length-1;
        int result=start;
        while(low<=high){

            int mid=(low+high)/2;
            if(arr[mid]==num && (mid==end || arr[mid+1]!=num)){
                return mid;
            }
            else if(arr[mid]>num)
                high=mid-1;
            else
                low=mid+1;
        }
        return result;

    }

    @Test
    public void test1(){
        int[] arr={1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10};
        countFrequency(arr);
        //assertEquals(true,true);

    }


}
