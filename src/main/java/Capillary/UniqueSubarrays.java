package Capillary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class UniqueSubarrays {

    public static ArrayList<Integer> coolNumbers=new ArrayList<Integer>();

    class InputReader{
        BufferedReader br;
        StringTokenizer token;

        public InputReader(InputStream stream){
            br=new BufferedReader(new InputStreamReader(stream));
            token=null;
        }

        public String next(){
            while(token==null || !token.hasMoreTokens()){
                try{
                    token= new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public int nextInt(){
            return  Integer.parseInt(next());
        }
    }

    public static void main(String args[]){
        InputReader in= new UniqueSubarrays().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        generateCoolNumbers();
        out.print(coolNumbers);
        //int T=in.nextInt();
        //solve(in,out,T);
        out.close();
        System.exit(0);
    }

    private static void generateCoolNumbers() {
        for(int numOfDigits=1;numOfDigits<=9;numOfDigits++) {
                computeCoolNumber(numOfDigits);
        }

    }

    private static void computeCoolNumber(int numOfDigits) {

        int maxNumber = (int) Math.pow(2, numOfDigits);
        for (int n = 1; n <= maxNumber; n++) {
            coolNumbers.add(calculateNthCoolNumber(n,numOfDigits));

        }
    }

    private static int calculateNthCoolNumber(int num,int numOfDigits) {


        int[] binaryDigitsArray = findBinaryEquivalent(num-1,numOfDigits);
        int coolNumber = 0;
        for (int i = 0; i < numOfDigits; i++) {
            int digit = binaryDigitsArray[i] == 0 ? 2 : 5;
            coolNumber += Math.pow(10, numOfDigits - i - 1) * digit;
        }
        return coolNumber;
    }

    private static int[] findBinaryEquivalent(int number,int numOfDigits) {
        int[] binaryDigitsArray=new int[numOfDigits];
        int rem;
        int k=numOfDigits;
        int q=-1;
        while(q!=1 && number!=0){
            rem=number%2;
            binaryDigitsArray[(k--)-1]=rem;
            number=number/2;
            q=rem/2;
        }
        return binaryDigitsArray;
    }
}
