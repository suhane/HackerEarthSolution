package expedia;

import org.junit.Test;

import java.util.HashMap;

public class CountDistinctElements {

    public void countDistinct(int[] arr, int k) {

        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int dist_Count = 0;

        int i;
        for (i = 0; i < k; i++) {
            if (!hm.containsKey(arr[i])) {
                dist_Count++;
                hm.put(arr[i], 1);

            } else {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
        }

        System.out.println(dist_Count);

        for (; i < n; i++) {
            if (hm.containsKey(arr[i - k])) {
                if (hm.get(arr[i - k]) == 1) {
                    dist_Count--;
                    hm.remove(arr[i - k]);
                } else
                    hm.put(arr[i - k], hm.get(arr[i - k]) - 1);
            }
            if (!hm.containsKey(arr[i])) {
                dist_Count++;
                hm.put(arr[i], 1);

            } else {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
            System.out.println(dist_Count);
        }
    }

        @Test
        public void test(){
            int[] arr={1, 2, 1, 3, 4, 2, 3};
            countDistinct(arr,4);
        }








}
