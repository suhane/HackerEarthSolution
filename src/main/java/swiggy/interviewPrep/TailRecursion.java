package swiggy.interviewPrep;

public class TailRecursion {

    public long fact(long n){
        if(n==1)
            throw new RuntimeException();
        return n*fact(n-1);
    }


    public long factTR(long n,long p){
        if(n==1)
            return p;
        return factTR(n-1,p*n);
    }




    public static void main(String s[]){
        System.out.println(new TailRecursion().factTR(5,1));
    }

}
