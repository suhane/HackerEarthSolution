package interviewBits.binarySearch;

import java.util.ArrayList;

/**
 * Created by labuser on 7/23/17.
 */
public class AllocateBooks {

    public static int books(ArrayList<Integer> a, int b) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int el:a){
            max+=el;
            min=Math.min(el,min);
        }
        int low=min;
        int high=max;
        int result=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=isAllocationPosible(a,mid,b);
            if(val==1){
                result =Math.min(result,mid);
                high=mid-1;
            }else if(val<0)
                high=mid-1;
            else low=mid+1;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

    private static int isAllocationPosible(ArrayList<Integer> c, int max, long maxStudents) {
        int _max = max_element(c);
        if(_max > max)
            return 0;
        int n=c.size();
        if(_max == max && maxStudents<=n)
            return 1;
        int i=0;
        long sum=0L;
        int cnt=1;
        while(i<n){
            if(sum+c.get(i)>max){
                sum=0;
                cnt++;
            }
            else{
                sum+=c.get(i);
                i++;

            }
        }

        if(cnt==maxStudents)
            return 1;
        else
            if(cnt<maxStudents)
                return -1;
            else
                return 0;
    }

    private static int max_element(ArrayList<Integer> c) {

        int n= c.size();
        int max=Integer.MIN_VALUE;
        for(int el:c){
            max=Math.max(max,el);
        }
        return max;
    }

    public static void main(String args[]){
        int[] arr={97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr){
            a.add(x);
        }
        System.out.println(books(a,26));
    }
}
