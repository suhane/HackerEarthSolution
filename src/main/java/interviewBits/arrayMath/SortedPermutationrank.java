package interviewBits.arrayMath;

/**
 * Created by labuser on 7/17/17.
 */
public class SortedPermutationrank {
    public static int findRank(String a) {
        int len=a.length();
        long elemBefore=0L;
        long fact=1L;
        for(int i=len-1;i>=1;i--){
            fact*=i;
        }
        for(int i=0; i<len-1;i++){
            char c=a.charAt(i);
            int j=i+1;
            int elem=0;
            while(j<len){
                if(c>a.charAt(j))
                    elem++;
                j++;
            }
            elemBefore+=elem*fact;
            fact=fact/(len-i-1);
        }
        int ans= (int) ((elemBefore+1)%1000003);
        return ans;

    }
    public static void main(String s[]){
        findRank("acd");
    }
}
