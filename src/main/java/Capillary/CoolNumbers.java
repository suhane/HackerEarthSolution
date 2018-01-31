package Capillary;


import java.util.ArrayList;

/**
 * Created by suhane on 10/2/16.
 */
public class CoolNumbers {



    public static ArrayList<Integer> coolNumbers=new ArrayList<Integer>();



    public static void main(String args[]){
        generateCoolNumbers(); // will generate all cool numbers between 1 to 10^9
        System.out.println(coolNumbers);
    }

    private static void generateCoolNumbers() {
        for(int numOfDigits=1;numOfDigits<=9;numOfDigits++) { // iterating from a single digit upto nine-digit
            computeCoolNumber(numOfDigits); //will generate all cool number for a given number of digits
        }

    }

    private static void computeCoolNumber(int numOfDigits) {

        int maxNumber = (int) Math.pow(2, numOfDigits); // for every k number of digit there can be maximum of 2^k cool numbers
        for (int n = 1; n <= maxNumber; n++) {
            coolNumbers.add(calculateNthCoolNumber(n,numOfDigits));

        }
    }

    private static int calculateNthCoolNumber(int num,int numOfDigits) {

/*
* Generating a k-digit binary number for each number. From the binary digits cool number is calculated assuming 0 is 2 and 1 is 5
 */

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

