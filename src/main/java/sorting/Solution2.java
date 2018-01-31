package sorting;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    static int insertionSort(int ar_size, int[] ar) 
    {
        int key=0,i=0,j=0,count=0;
        
        for(i=1;i<ar_size;i++)
        {
            key=ar[i];
    
            for(j=i-1;j>=0;j--)
            {
                if( key < ar[j] )
                {
                    ar[j+1]=ar[j];
                    ++count;
                }
                else
                    break;
            }
            ar[j+1]=key;
 
        }
        
        return count;
    }
    
    static int quickSort(int begin,int end,int[] arr) {
  if(begin<end)
  {
     int count=0,key=arr[end],i=begin-1,j=begin;
    
     for(;j<end;++j)
     {
        if(arr[j]<=key)  
              {
                  ++i;
                  int temp = arr[i];
                  arr[i]=arr[j];
                  arr[j]=temp;
            ++count;
              }
     }     
  
      arr[end]=arr[i+1];
      arr[i+1]=key;
      ++count;
      int pos=i+1;
      
    int left = quickSort(begin,pos-1,arr);
    int right = quickSort(pos+1,end,arr);
               
      return (left+right+count);
   }   
        return 0;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        int[] arr1 = new int[N];
        
        for(int i=0;i<N;++i)
            arr[i]=arr1[i]=sc.nextInt();
        System.out.println(insertionSort(N,arr));
        System.out.println(quickSort(0,N-1,arr1));
    }
}