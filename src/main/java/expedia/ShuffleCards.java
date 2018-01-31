package expedia;

import org.junit.Test;

public class ShuffleCards {

    public void shuffle(int[] arr){

        int n=arr.length;

        for(int i=0;i<n;i++){

            int r= (int) (i+ Math.random()* (n-i));

            int temp=arr[i];
            arr[i]=arr[r];
            arr[r]=temp;

        }
    }

    @Test
    public void test(){
        int[] arr=new int[52];
        for(int i=0;i<52;i++){
            arr[i]=i+1 ;
        }
    shuffle(arr);
    }

}
