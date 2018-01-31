package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Created by labuser on 7/26/17.
 Input :
 Array = {1 1 0 1 1 0 0 1 1 1 }
 M = 1

 Output :
 [0, 1, 2, 3, 4]
 */
public class MaxContinuousSeries {

    public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

        // Left and right indexes of current window
        int wL = 0, wR = 0;

        // Left index and size of the widest window
        int bestL = 0, bestWindow = 0;
        int n=a.size();
        int zeroCount=0;
        ArrayList<Integer> answer=new ArrayList<Integer>();
        while(wR<n){
            if (zeroCount <= b)
            {
                if (a.get(wR) == 0)
                    zeroCount++;
                wR++;
            }
            if (zeroCount > b)
            {
                if (a.get(wL) == 0)
                    zeroCount--;
                wL++;
            }
            // Update widest window if this window size is more
            if (wR-wL > bestWindow)
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
        }

        for(int i=0;i<bestWindow;i++){
            answer.add(bestL++);
        }
        return answer;

    }

    public static void main(String args[]){
        int[] arr={1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.println(maxone(a,2));
    }
}
