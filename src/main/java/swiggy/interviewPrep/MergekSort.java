package swiggy.interviewPrep;

import org.junit.Assert;
import org.junit.Test;

public class MergekSort {

    class MinHeapNode {

        int element; // The element to be stored
        int arrayIndex; // index of the array from which the element is taken
        int nextElemIndex; // index of the next element to be picked from array

        public MinHeapNode(int elem, int arrayIndex,int nextElemIndex){
            this.element=elem;
            this.arrayIndex=arrayIndex;
            this.nextElemIndex = nextElemIndex;

        }

        @Override
        public String toString() {
            return "[Element="+this.element+", FromArray:"+this.arrayIndex+", NextElement:"+this.nextElemIndex;
        }
    }
    class MinHeap{

        MinHeapNode[] harr;
        int heap_size;

        MinHeap(MinHeapNode[] arr){
            this.harr=arr;
            this.heap_size=arr.length;
            // Build heap (rearrange array)
            for (int i = heap_size / 2 - 1; i >= 0; i--)
                minHeapify(i);
        }

        int left(int i){
            return 2*i+1;
        }

        int right(int i){
            return 2*i+2;
        }

        MinHeapNode getMin(){
            return this.harr[0];
        }
        void replaceMin(MinHeapNode x) {

            harr[0] = x;
            minHeapify(0);

        }

        private void minHeapify(int i) {

            int smallest = i;
            int left=left(i);
            int right=right(i);

            if(left<heap_size && harr[left].element<harr[i].element)
                smallest=left;
            if(right<heap_size && harr[right].element<harr[smallest].element)
                smallest=right;

            if(smallest!=i){

                MinHeapNode temp=harr[smallest];
                harr[smallest]=harr[i];
                harr[i]=temp;
                minHeapify(smallest);

            }



        }


    }

    public int[] mergekArrays(int[][] arr){

        int k=arr.length;
        int n=arr[0].length;

        int[] output=new int[k*n];
        MinHeapNode[] harr= new MinHeapNode[k];

        for (int i = 0; i < k; i++)
        {
            harr[i]=new MinHeapNode(arr[i][0],i,1);
        }

        MinHeap minHeap=new MinHeap(harr);

        for (int count = 0; count < n*k; count++) {

            MinHeapNode root= minHeap.getMin();
            output[count]=root.element;

            if (root.nextElemIndex < n) {

                root.element=arr[root.arrayIndex][root.nextElemIndex];
                root.nextElemIndex++;
            }
            else root.element=Integer.MAX_VALUE;

            minHeap.replaceMin(root);
        }

        return output;



    }


    @Test
    public void test(){
        int[][] arr={{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        int[] output=mergekArrays(arr);
        int[] expected={1,2,6,9,12,20,23,34,34,90,1000,2000};
        Assert.assertArrayEquals(output,expected);

    }

}
