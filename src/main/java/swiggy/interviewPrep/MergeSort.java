package swiggy.interviewPrep;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class MergeSort {

    private void merge(int[] arr, int l, int m, int r){

        int l1=m-l+1;
        int l2=r-m;
        int start=l;
        int[] temp1= new int[l1];
        int[] temp2= new int[l2];

        int i=0;
        while (l<=m){
            temp1[i++]=arr[l++];
        }
        i=0;
        m++;
        while (m<=r){
            temp2[i++]=arr[m++];
        }

        int ptr1=0,ptr2=0;

        while(ptr1<l1 && ptr2<l2){

            if(temp1[ptr1]<=temp2[ptr2]){
                arr[start++]=temp1[ptr1++];
            }
            else {
                arr[start++]=temp2[ptr2++];
            }
        }

        while (ptr1<l1){
            arr[start++]=temp1[ptr1++];
        }
        while (ptr2<l2){
            arr[start++]=temp2[ptr2++];
        }

    }

    public void mergeSort(int[] arr, int l, int r){
        if (l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);

        }
    }

    public void sort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    //@Test
    public void testMerge(){
        int[] arr={1,5,3,7};
        int l=0;
        int r=3;
        int m=(l+r)/2;
        merge(arr,l,m,r);

    }

    @Test
    public void testMergeSort(){
        int[] arr={5,1,7,3,8,2,1,9,6};
        sort(arr);
        int[] expected={1,1,2,3,5,6,7,8,9};
        Assert.assertArrayEquals(arr,expected);
    }
}
