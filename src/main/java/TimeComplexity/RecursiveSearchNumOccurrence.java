package TimeComplexity;

/**
 * Created by suhane on 5/26/17.
 */
public class RecursiveSearchNumOccurrence {

    public static void main(String args[]){
        int[] arr={1,1,1,1,1,1,1,1,1,1};
        int k=1;
        int occ=searchNumOccurrence(arr,k,0,9);
    }

    static int searchNumOccurrence(int[] V, int k, int start, int end) {
        System.out.println("start="+start+" "+" end="+end);
        if (start > end) return 0;
        int mid = (start + end) / 2;
        if (V[mid] < k) return searchNumOccurrence(V, k, mid + 1, end);
        if (V[mid] > k) return searchNumOccurrence(V, k, start, mid - 1);
        return searchNumOccurrence(V, k, start, mid - 1) + 1 + searchNumOccurrence(V, k, mid + 1, end);
    }
}
