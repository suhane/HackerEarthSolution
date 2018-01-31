package sorting;

import java.util.Scanner;

public class Driver {
	public static void main(String args[]){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int[] A=new int[n];
	int[] B=new int[n];
	int[] C=new int[n];
	int iter=0;
	while(iter<n){
		int x=in.nextInt();
		A[iter]=x;
		B[iter]=x;
		C[iter++]=x;
	}
	SelctionSort.sort(A);
	InsertionSort.sort(B);
	BubbleSort.sort(C);
	
	}
}
