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
        //generateCoolNumbers();
        //out.print(coolNumbers);
        int l=in.nextInt();
        int r=in.nextInt();
        solve(in,out,l,r);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, int l, int r) {

        int l_digits=findDigits(l);
        int maxCoolNumber=calculateMaxCoolNumber(l_digits);
        if(maxCoolNumber<l)
            l_digits++;
        out.println(computeCoolNumber(l_digits,l,r));

    }

    private static int calculateMaxCoolNumber(int l_digits) {


        int maxCoolNumber=0;
        while(l_digits>0){
            maxCoolNumber+=5*Math.pow(10,--l_digits);
        }
        return maxCoolNumber;
    }

    private static int findDigits(int l) {

        int digit=0;
        while(l>0){
            l=l/10;
            digit++;
        }
        return digit;
    }



    private static long computeCoolNumber(int numOfDigits,int l,int r) {

        int maxNumber = (int) Math.pow(2, numOfDigits);
        int n=1;
        int coolNumber=-1;
        int prevcoolnumber=0;
        long sum=0;
        while(coolNumber<=r){
            coolNumber=calculateNthCoolNumber(n++,numOfDigits);
            if(coolNumber>l ){
                if(prevcoolnumber==0) {
                    if(coolNumber>=r)
                        sum += coolNumber * (r-l+1);
                    else
                        sum += coolNumber * (coolNumber-l);
                }
                else
                    sum+=coolNumber * (r-prevcoolnumber+1);
                prevcoolnumber=coolNumber;
            }

            if(n==maxNumber+1){
                n=1;
                maxNumber = (int) Math.pow(2, ++numOfDigits);
            }

        }

        return sum;
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
