package sorting;

public class BinarySearch {
	public static int search(int[] A,int key){
		int start=0;
		int end=A.length;
		int mid=(start+ end)/2;
		while(A[mid]!= key){
			if(A[mid]<key)
				start=mid;
			else
				end=mid;
			mid=(start+end)/2;
		}
		return mid;
	}
}
