package interviewBits.arrayMath;

/**
 * Created by labuser on 7/15/17.
 */
public class Power {

    public static boolean isPower(int a) {
        // Base case
        if (a <= 1)
            return false;

        // Try all numbers from 2 to sqrt(n) as base
        for (int x=2; x<=Math.sqrt(a); x++)
        {
            int p = x;

            // Keep multiplying p with x while is smaller
            // than or equal to x
            while (p <= a)
            {
                p *= x;
                if (p == a)
                    return true;
            }
        }
        return false;
    }

    public static boolean isPower2(int a) {
        // Base case
        if (a <= 1)
            return false;

        // Try all numbers from 2 to sqrt(n) as base
        for (int x=2; x<=Math.sqrt(a); x++)
        {
            int y = 2;
            int p = (int)Math.pow(x, y);

            // Keep increasing y while power 'p' is smaller
            // than n.
            while (p<=a && p>0)
            {
                if (p==a)
                    return true;
                y++;
                p = (int)Math.pow(x, y);
            }
        }
        return false;
    }

    public static void main(String args[]){
        isPower2(1024000000);
    }
}
