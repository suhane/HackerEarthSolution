package swiggy.interviewPrep;


import org.junit.Assert;
import org.junit.Test;

public class MaxHeap {

    private int[] arr;

    public int getSize() {
        return size;
    }

    private int size;
    public MaxHeap(){

        arr=new int[10];
        size=0;
    }


    public void add(int elem){

        int i=size;
        size++;
        if(i==0){
            arr[i]=elem;
        }
        arr[i]=elem;
        shiftUp(i);

    }

    public int getMax(){
        if(size>0)
            return arr[0];
        else
            throw  new RuntimeException("Empty Heap");

    }

    public int removeMax(){
        int max=arr[0];
        arr[0]=arr[size-1];
        size--;
        shiftDown(0);
        return max;
    }

    private void shiftDown(int i) {

        int l=2*i+1;
        int r=2*i+2;
        int largest=i;

        if(l<size && arr[l]>arr[largest])
            largest=l;
        if(r<size && arr[r]>arr[largest])
            largest=r;

        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            shiftDown(largest);
        }

    }

    private void shiftUp(int i) {

        while(i>0){

            int parent=(i-1)/2;
            if(arr[parent]<arr[i]){

                int temp=arr[parent];
                arr[parent]=arr[i];
                arr[i]=temp;
                i=parent;
            }
            else
                break;

        }

    }


    @Test
    public void test(){

        add(2);
        add(4);
        add(1);
        add(6);
        Assert.assertTrue(getMax()==6);
    }

}

