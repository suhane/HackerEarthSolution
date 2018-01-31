package prep.code;

import java.util.Stack;

public class NextGreatestElement {

    public int[] nextGreatest(int[] arr){

        int[] nge=new int[arr.length];
        int l=arr.length;
        nge[l-1]=-1;
        for(int i=l-2;i>=0;i--){

            if(arr[i]<arr[i+1]){
                if(nge[i+1]!=-1){
                    nge[i]=Math.min(nge[i+1],arr[i+1]);
                }
                else
                    nge[i]=arr[i+1];
            }
            else
                nge[i]=arr[i]>nge[i+1]?-1:nge[i+1];
        }
        return nge;
    }


    public void printNGE(int arr[], int n)
    {
        int i = 0;
        Stack<Integer> s = new Stack<Integer>();
        int element, next;

        /* push the first element to stack */
        s.push(arr[0]);

        // iterate for rest of the elements
        for (i = 1; i < n; i++)
        {
            next = arr[i];

            if (s.isEmpty() == false)
            {

                // if stack is not empty, then
                // pop an element from stack
                element = s.pop();

                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
                while (element < next)
                {
                    System.out.println(element + " -- " + next);
                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                /* If element is greater than next, then
                   push the element back */
                if (element > next)
                    s.push(element);
            }

            /* push next to stack so that we can find next
               greater for it */
            s.push(next);
        }

        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
        while (s.isEmpty() == false)
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    public static void main(String args[]){

        /*int[] nge= new NextGreatestElement().nextGreatest(new int[]{11, 13, 21, 3});
        for(int i=0;i<nge.length;i++){
            System.out.println(nge[i]);
        }
        */

        int arr[] = { 5, 4, 3, 2,6 };
        int n = arr.length;
        new NextGreatestElement().printNGE(arr, n);



    }

}
