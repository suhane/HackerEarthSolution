package interviewBits.arrayMath;

/**
 * Created by labuser on 7/29/17.
 */
public class GridUniquePath {

    public static int uniquePaths(int a, int b) {
        if(a==1 || b==1){
            return 1;

        }
        int n=a+b-2;
        long ans=1;
        long div1=1;
        long div2=1;
        a--;
        b--;

        while(n>=1){
            if(ans%a==0 && a!=1) {
                ans /= a;
                div2*=b;
            }else if(ans%b==0 && b!=1){
                ans/=b;
                div1*=a;
            }
            else{
                div1*=a;
                div2*=b;
            }

            if(ans%div1==0) {
                ans/=div1;
                div1=1;
            }
            if(ans%div2==0) {
                ans/=div2;
                div2=1;
            }
            ans*=n;
            if(a>1)a--;
            if(b>1)b--;
            n--;
        }
        ans/=div1;
        ans/=div2;
        return (int) ans;
    }

    public static void main(String args[]){
        System.out.print(uniquePaths(14,15));
    }
}
