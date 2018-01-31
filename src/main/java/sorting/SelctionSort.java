package sorting;

public class SelctionSort {
	public static void sort(int[] A ){
		int len=A.length;
		int s=0;
		for(int i=0;i<len-1;i++){
			int min=i;
			for(int j=i+1;j<len;j++){
				if(A[j]<A[min]){
					min=j;
				}
			}
			int temp=A[i];
			A[i]=A[min];
			A[min]=temp;
			s+=min-i;
			
		}
		System.out.println("Number of shifts in from selection sort= "+s);
	}
}
