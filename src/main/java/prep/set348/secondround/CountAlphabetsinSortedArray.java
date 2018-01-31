package prep.set348.secondround;

public class CountAlphabetsinSortedArray {

    public void countAlphabets(String str){
        char[] arr=str.toCharArray();
        int len=arr.length;
        int i=0;
        while(i<len){
            int lastOccurence=findLastOccurence(arr,i,len-1,arr[i]);
            System.out.println(arr[i]+ "->" +(lastOccurence-i+1));
            i=lastOccurence+1;
        }


    }



    private int findLastOccurence(char[] arr, int low, int high, char c) {

        if(arr[high]==c)
            return high;

        int n=high;

        while(low<=high){
            int mid=(low+high)/2;
            if(mid<n && arr[mid+1]>c && arr[mid]==c )
                return mid;
            else if(arr[mid]>c)
                high=mid-1;
            else low=mid+1;

        }
        return -1;
    }

    public static void main(String[] args)
    {
        CountAlphabetsinSortedArray count = new CountAlphabetsinSortedArray();
        count.countAlphabets("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
    }
}
