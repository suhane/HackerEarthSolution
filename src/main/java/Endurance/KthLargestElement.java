package Endurance;

public class KthLargestElement {

    public static int kthLargest(int[] arr, int k){

        int n=arr.length;
        for(int i=n/2-1; i>=0;i--){
            percolateDown(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){

            if(n-i==k)
                return arr[0];
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            percolateDown(arr,i,0);
        }

        return -1;

    }

    private static void percolateDown(int[] arr, int n, int i) {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;

        if(l<n && arr[l]>arr[largest])
            largest=l;
        if(r<n && arr[r]>arr[largest])
            largest=r;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            percolateDown(arr,n,largest);
        }

    }

    public static void main(String s[]){

        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("The Drop was within Noida from Adobe132 office to Sec26.The invoice is showing 44km.Its hardly 12km".length());

    }
}
