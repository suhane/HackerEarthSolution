package sorting;
import java.util.Scanner;
/*
 * 
 * 20
0 ab
6 cd
0 ef
6 gh
4 ij
0 ab
6 cd
0 ef
6 gh
0 ij
4 that
3 be
0 to
1 be
5 question
1 or
2 not
4 is
2 to
4 the
 * 
 * 
 * 
 * 
 * 
 * */
public class CountingSort {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] arr=new int[n];
		String[] input=new String[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
			String discard=in.next();
			if(i<n/2)
				input[i]="-";
			else
				input[i]=discard;
		}
		sort(arr,input,n);
	}

	private static void sort(int[] arr, String[] input, int n) {
		int[] count=new int[100];
		int[] outputArray =new int[n];
		String[] outputStringArray =new String[n];
		for(int i=0;i<n;i++)
			count[arr[i]]++;
		
		
		for(int i=1;i<100;i++){
			count[i]=count[i] + count[i-1];
		}
		
		for(int i=n-1;i>=0;i--){
			outputArray[count[arr[i]]-1]=arr[i];
			outputStringArray[count[arr[i]]-1]=input[i];
			--count[arr[i]];
		}
		
		for(String el: outputStringArray){
			System.out.print(el+ " ");
		}
		System.out.println();
	}
}
