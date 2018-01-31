package test;
/**
 * Created by suhane on 5/26/17.
 */
public class RecursiveSearchNumberOccurrence {

    public static void main(String args[]){
        int[] arr={1,1,1,1,1,1,1,1,1,1};
        int k=1;
        searchNumberOccurrence(arr,k,0,9);
    }

    static int searchNumberOccurrence(int[] V, int k, int start, int end) {
        if (start > end) return 0;
        int mid = (start + end) / 2;
        if (V[mid] < k) return searchNumberOccurrence(V, k, mid + 1, end);
        if (V[mid] > k) return searchNumberOccurrence(V, k, start, mid - 1);
        return searchNumberOccurrence(V, k, start, mid - 1) + 1 + searchNumberOccurrence(V, k, mid + 1, end);
    }
}
