package interviewBits.dynamicProgramming;

public class IntersectingChordsInACircle {


    public static int chordCnt(int A) {

        long[] points= new long[A+1];
        points[0]=1;
        points[1]=1;
        int mod=1000000007;

        for(int i=2;i<=A;i++){

            for(int j=0;j<i;j++){

                points[i]= (points[i] + ((points[j]%mod)*(points[i-j-1]%mod))%mod)%mod;
            }
        }

        return (int) points[A];

    }



    public static int chordCntRecur(int A) {

        if(A==0)
            return 1;
        if(A==1)
            return 1;
        int ans=0;
        for(int i=0;i<A;i++){
            ans+=chordCnt(i)*chordCnt(A-i-1);
        }
        return ans;

    }

    public static void main(String s[]){
        System.out.println(chordCnt(1000));
    }
}
