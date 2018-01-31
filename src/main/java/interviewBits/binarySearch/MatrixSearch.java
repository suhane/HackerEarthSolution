package interviewBits.binarySearch;

import java.util.ArrayList;

/**
 * Created by labuser on 7/23/17.
 */
public class MatrixSearch {
    public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = isTargetRow(a.get(mid), b);
            if (val == 0)
                return searchRow(a.get(mid), b);
            else if (val < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;

    }

    private static int searchRow(ArrayList<Integer> a, int b) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) == b)
                return 1;
            else if (a.get(mid) > b)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }

    private static int isTargetRow(ArrayList<Integer> arr, int target) {
        int max = arr.get(arr.size() - 1);
        int min = arr.get(0);
        if (target < min) return -1;
        else if (target >= min && target <= max) return 0;
        else return 1;


    }


    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 50};
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++)
                temp.add(arr[count++]);
            a.add(temp);
        }
        System.out.print(searchMatrix(a, 3));
    }
}