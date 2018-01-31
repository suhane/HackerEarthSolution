package swiggy.interviewPrep;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {


    public void print(int[] arr, int k){

        Deque<Integer> deque= new LinkedList<Integer>();
        int n=arr.length;
        int i=0;
        for(i=0;i<k;i++){

            while(!deque.isEmpty() && arr[i]>arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);
        }

        for(;i<n;i++){

            System.out.println(arr[deque.getFirst()]);

            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && arr[i]>arr[deque.peekLast()]){
                deque.removeLast();
            }

            deque.addLast(i);

        }
        System.out.println(arr[deque.getFirst()]);
    }

    @Test
    public void test(){
        int[] arr= {-1,-3,-5,-9,1,5,6,3,-3,11,2,13,4};
        print(arr,4);
    }
}
