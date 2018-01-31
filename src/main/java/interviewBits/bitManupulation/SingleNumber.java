package interviewBits.bitManupulation;

import java.util.List;

/**
 * Created by labuser on 7/24/17.
 */
public class SingleNumber {
    public int singleNumber(final List<Integer> a) {

            int temp=a.get(0);
            int n=a.size();
            for(int i=1;i<n;i++){
                temp^=a.get(i);
            }
        return temp;
    }
}
