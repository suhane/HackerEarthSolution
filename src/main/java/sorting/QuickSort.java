package sorting;

import java.util.Scanner;

public class QuickSort {
	public static void main(String args[]){
		 Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int[] ar = new int[n];
         for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
         }
		quicksort(ar,0,n-1);
	}
	private static void quicksort(int[] a, int low, int high) {
		int pivot;
		if(low<high){
			pivot=partition(a,low,high);
			quicksort(a, low, pivot-1);
			quicksort(a, pivot+1, high);
		}
		
	}
	public static int partition(int[] A, int low ,int high){
		int left=low;
		int right=high;
		int pivot=A[low];
		while(left<right){
			while(A[left]<=pivot && left<high)
				left++;
			while(A[right]>pivot)
				right--;
			if(left<right)
				swap(A,left,right);
		}
		A[low]=A[right];
		A[right]=pivot;
		
		
		return right;
		
		
	}
	
	private static void printArray(int[] a) {
		for(int el: a)
			System.out.print(el);
		System.out.println();
	}
	static void printArray(int[] ar,int st,int en) {
        for(int i=st;i<en;i++){
           System.out.print(ar[i]+" ");
        }
          System.out.println("");
     }

	private static void swap(int[] a, int left, int right) {
		int temp=a[left];
		a[left]=a[right];
		a[right]=temp;
		
	}
}
