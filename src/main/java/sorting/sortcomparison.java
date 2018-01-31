package sorting;
import java.util.*;
public class sortcomparison {
    
	public static int qswaps=0;
	public static int iswaps=0;
	
    static void quickSort(int[] ar) {
        quicksort(ar,0,ar.length-1);
    }
    
    static void insertionSort(int[] A){	
		int l=A.length;
		for(int i=1;i<l;i++){
			int j=i;
			int temp=A[i];
			while(j>=1 && A[j-1]>temp){
				A[j]=A[j-1];
				j--;
			}
			A[j]=temp;
			iswaps+=i-j;
			
		}
    }
    static void quicksort(int ar[],int st,int en){
        if(st<en){
            int pos=partition(ar,st,en);
            quicksort(ar,st,pos-1);
            quicksort(ar,pos+1,en);
            
        }
    }
    static int partition(int[] A,int low,int high) {
    	int left=low;
		int right=high;
		int pivot=A[high];
		int swap=0;
		while(left<right){
			while(A[left]<pivot ){
				left++;
				swap++;
			}
			while( right>=0 && A[right]>=pivot)
				right--;
			if(left<right){
				swap(A,left,right);
			}
		}
		
		A[high]=A[left];
		A[left]=pivot;
			qswaps+=swap+1;
		return left;
    }   
    private static void printArray(int[] a) {
		for(int el: a)
			System.out.print(el+" ");
		System.out.println();
	}

	private static void swap(int[] a, int left, int right) {
		int temp=a[left];
		a[left]=a[right];
		a[right]=temp;
		
		
	}
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] q_ar = new int[n];
           int[] i_ar = new int[n];
           for(int i=0;i<n;i++){
              int k=in.nextInt();
              q_ar[i]=k;
              i_ar[i]=k;
           }
           quickSort(q_ar);
           insertionSort(i_ar);
           System.out.println(iswaps);
           System.out.println(qswaps);
           System.out.println(iswaps-qswaps);
       }    
   }
