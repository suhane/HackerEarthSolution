package sorting;

public class InsertionSort {
	public static void sort(int[] A){	
		int l=A.length;
		int s=0;
		for(int i=1;i<l;i++){
			int j=i;
			int temp=A[i];
			while(j>=1 && A[j-1]>temp){
				A[j]=A[j-1];
				j--;
			}
			A[j]=temp;
			s+=i-j;
			
		}
		System.out.println("Number of shifts in from insertion sort= "+s);

	} 
}
