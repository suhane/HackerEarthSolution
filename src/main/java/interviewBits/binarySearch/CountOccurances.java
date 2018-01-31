package interviewBits.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/22/17.
 */
public class CountOccurances {

    public static int findCount(final List<Integer> a, int b) {
        int first=findOccurennce(a,b,true);
        int last=findOccurennce(a,b,false);

        if(first==-1)
            return 0;
        return last-first+1;

    }


    public static int findOccurennce(final List<Integer> a, int b, boolean searchFirst) {

        int low=0;
        int high=a.size()-1;
        int mid;
        int result=-1;

        while(low<=high){

            mid=(low+high)/2;
            if(a.get(mid)==b){
                result=mid;
                if(searchFirst)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if(a.get(mid)>b)
                    high=mid-1;
            else
                low=mid+1;


        }
        return result;

    }

    public static void main(String args[]){
        List<Integer> a=new ArrayList<Integer>();
        a.add(5);
        a.add(7);
        a.add(7);a.add(8);a.add(8);a.add(10);
        findCount(a,8);
    }
}
