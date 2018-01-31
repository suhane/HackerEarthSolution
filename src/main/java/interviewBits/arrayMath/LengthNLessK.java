package interviewBits.arrayMath;

import java.util.ArrayList;

/**
 * Created by labuser on 7/28/17.
 *
 * Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set.
 Examples:

 Input:
 3 0 1 5
 1
 2
 Output:
 2 (0 and 1 are possible)

 Input:
 4 0 1 2 5
 2
 21
 Output:
 5 (10, 11, 12, 15, 20 are possible)
 Constraints:

 1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */
public class LengthNLessK {
    public static int solve(ArrayList<Integer> A, int B, int C) {
        int n=A.size();
        int digits=countDigits(C);

        if(B>digits){
            return 0;
        }
        else if(B<digits){
            // find all B digit nos from by combinations of A
            int count=A.get(0)==0?n-1:n;
            for(int i=1;i<B;i++){
                    count*=(n-i);

            }
            return count;
        }
        else{
            int unitPlace=unitPlace(C,digits);
            int lastPlace=lastPlace(C,digits);
            int l=possibleUnitPlaces(A,unitPlace);
            int count=A.get(0)==0?l-1:l;
            for(int i=1;i<l-1;i++){
                count*=(n-i);

            }
            return count;


        }

    }

    private static int possibleUnitPlaces(ArrayList<Integer> a, int unitPlace) {
        int l=a.size();
        int low=0;
        int high=l-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a.get(mid)==unitPlace)
                return mid+1;
            else
                if(a.get(mid)>unitPlace)
                    high=mid-1;
            else
                    low=mid+1;
        }
        return l;
    }


    private static int unitPlace(int c,int digits) {
            return (int) (c/Math.pow(10,digits-1));

    }

    private static int lastPlace(int c,int digits) {
        return c%10;

    }

    private static int countDigits(int c) {
        int count=0;
        while(c!=0){
            count++;
            c=c/10;
        }
        return count;
    }
}
