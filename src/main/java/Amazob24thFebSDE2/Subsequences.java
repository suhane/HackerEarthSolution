package Amazob24thFebSDE2;

public class Subsequences {

    public void getGoodSubsequences(String s){
        int combinationsForA=0;
        int combinationsForB=0;
        int combinationsForC=0;
        int numberOfAEncountered=0;
        char letters [] = s.toCharArray();
        for(int i=0;i<letters.length;i++){
            if(letters[i]=='a'){
                numberOfAEncountered = numberOfAEncountered+1;
                combinationsForA= (int) findCombinationsForA(numberOfAEncountered);
            }
            if(letters[i]=='b'){
                combinationsForB=combinationsForA+2*combinationsForB;
            }
            if(letters[i]=='c'){
                combinationsForC=combinationsForB+2*(combinationsForC);
            }
        }
        System.out.println("number of good subsequences--> "+combinationsForC);
    }

    static long findCombinationsForA(int n){
        long fact=0l;
        for(int i=n;i>=1;i--){
            fact=fact+( factorial(n)/(factorial(i)*factorial(n-i)));
        }
        return fact;
    }
    static long factorial(int n){
        return n==0?1:n*factorial(n-1);
    }

    public static void main(String args[]){

        Subsequences subseq = new Subsequences();

        subseq.getGoodSubsequences("a");
    }
}
