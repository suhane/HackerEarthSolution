package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by labuser on 7/24/17.
 */
public class ThreeSum {



    public static int threeSumClosest(ArrayList<Integer> a, int b) {

        Collections.sort(a);
        int n=a.size();
        int ans = b;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=a.get(i)+a.get(l)+a.get(r);
                if(sum==b)
                    return b;
                if(ans==b || Math.abs(b-sum)<Math.abs(b-ans))
                    ans=sum;
                if(sum>b){
                    while(l<r && a.get(r)==a.get(r-1))
                        r--;
                    r--;
                }
                else{
                    while(l<r && a.get(l)==a.get(l+1))
                        l++;
                    l++;
                }
            }

        }

        return ans;
    }

    public static void main(String args[]){

        int[] arr1={ 5, -2, -1, -10, 10};

        ArrayList<Integer> a=new ArrayList<Integer>();

        for(int x:arr1){
            a.add(x);
        }
        System.out.print(threeSumClosest(a,5));
    }
}
