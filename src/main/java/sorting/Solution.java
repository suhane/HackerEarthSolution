package sorting;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]){
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=in.nextInt();
		solve(arr,n);
	}

	private static void solve(int[] arr, int n) {
		quicksort(arr,0,n-1);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int el : arr)
			System.out.print(el +" ");
		System.out.println();
	}

	private static void quicksort(int[] arr, int low, int high) {
		if(low<high){
			int pivot = partition(arr,low,high);
			quicksort(arr,low,pivot-1);
			quicksort(arr,pivot+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int left=low;
		int right=high;
		int pivot=arr[low];
		while(left<right){
			while(arr[left]<=pivot && left<high)
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<right)
				swap(arr,left,right);
		}
		arr[low]=arr[right];
		arr[right]=pivot;
		return right;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}
}
