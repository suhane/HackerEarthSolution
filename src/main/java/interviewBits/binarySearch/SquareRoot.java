package interviewBits.binarySearch;

/**
 * Created by labuser on 7/22/17.
 */
public class SquareRoot {

    public static int getRoot(int a){
        if(a==0)
            return 0;

        int low=1;
        int high=a;
        int mid=1;
        while(low<=high){
            mid=low +(high-low)/2;
            if(mid<=a/mid && (mid+1)>a/(mid+1))
                return mid;
            if(mid>a/mid)
                high=mid-1;
            else
                low=mid+1;

        }
        return mid;

    }

    public static void main(String args[]){
        System.out.print(getRoot(2147483647));
    }
}
