package interviewBits.graphs;

public class SmallestSequenceWithGivenPrimes {

    public int[] solve2(int A, int B, int C, int D) {

        int[] ans=new int[D];
        int i=0;
        int start=2;
        while (i<D) {
            int no=start;
            no=maxDivide(no,A);
            no=maxDivide(no,B);
            no=maxDivide(no,C);

            if(no==1)
                ans[i++]=start;
            start++;

        }
        return ans;


    }

    private int maxDivide(int no, int a) {

        while (no%a==0){
            no/=a;
        }
        return no;
    }

    public int[] solve(int A, int B, int C, int D) {

        int[] ans=new int[D];
        int iA=0,iB=0,iC=0;
        int next_multiple_of_A=A,next_multiple_of_B=B,next_multiple_of_C=C;
        int curr_index=0;
        while(curr_index<D){
            int next_no=Math.min(next_multiple_of_A,Math.min(next_multiple_of_B,next_multiple_of_C));
            if(curr_index==0 || (curr_index>0 && next_no!=ans[curr_index-1]))
                ans[curr_index++]=next_no;

            if(next_no==next_multiple_of_A){
                next_multiple_of_A=ans[iA]*A;
                iA++;
            }
            else if(next_no==next_multiple_of_B){
                next_multiple_of_B=ans[iB]*B;
                iB++;
            }
            else {
                next_multiple_of_C=ans[iC]*C;
                iC++;
            }
        }
        return ans;
    }

    public static void main(String s[]){

        new SmallestSequenceWithGivenPrimes().solve(2,3,5,10);
    }
}
