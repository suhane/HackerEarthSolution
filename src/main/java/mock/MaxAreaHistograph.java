package mock;

import java.util.Stack;

public class MaxAreaHistograph {

    public static int maxArea(int[] arr){

        int maxArea=0;
        int l=arr.length;
        Stack<Integer> s= new Stack<Integer>();
        int i=0;
        while(i<l){

            if(s.isEmpty() || arr[s.peek()]<=arr[i]) {
                s.push(i);
                i++;
            }
            else{
                maxArea=Math.max(maxArea, arr[s.pop()]*(s.isEmpty()?1:i-s.peek()-1));
            }

        }

        while (!s.isEmpty()){
            maxArea=Math.max(maxArea, arr[s.pop()]*(s.isEmpty()?1:i-s.peek()-1) );

        }
        return maxArea;

    }

    public static void main(String s[]){

        int[] arr={1,4,3,2,5};
        System.out.println(maxArea(arr));
    }
}
