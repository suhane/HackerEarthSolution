package interviewBits.dynamicProgramming;

public class Steps {

    public static int climbStairs(int a) {
        int[] count=new int[a+1];
        count[0]=1;
        count[1]=1;
        for(int i=2;i<=a;i++){
            count[i]=count[i-1]+count[i-2];
        }
        return count[a];
    }

    public static void main(String s[]){
        System.out.println(climbStairs(5));
    }
}
