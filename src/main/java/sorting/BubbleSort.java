package sorting;

public class BubbleSort {

	public static void sort(int[] A){
		int s=0;
		int len=A.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(A[i]>A[j]){
					int temp=A[i];
					A[i]=A[j];
					A[j]=temp;
					s+=j-i;
				}
			}
		}
		System.out.println("Number of shifts in from bubble sort= "+s);
	}
}
