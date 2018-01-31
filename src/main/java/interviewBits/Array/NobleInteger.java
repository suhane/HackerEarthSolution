package interviewBits.Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by suhane on 7/1/17.
 */
public class NobleInteger {

    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        Collections.sort(A);
        for(int iter=0;iter<n;iter++){
            int p=A.get(iter);
            while(iter<n-1 && p==A.get(iter+1)){
                iter++;
            }
            if(p==(n-iter-1))
                return 1;

        }

        return -1;
    }

}
